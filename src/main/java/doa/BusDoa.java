import static org.neo4j.driver.Values.parameters;

import org.neo4j.driver.Record;
import org.neo4j.driver.Result;
import org.neo4j.driver.Session;
import org.neo4j.driver.types.Node;

public class BusDoa {

    public void createBusNode(String matricul, String nbrePlace, String numero) {
        try (Session session = driver.session()) {
            session.writeTransaction(tx ->
                    tx.run("CREATE (n:Bus {matricul: $matricul, nbrePlace: $nbrePlace, numero: $numero})",
                            parameters("matricul", matricul, "nbrePlace", nbrePlace, "numero", numero)));
        }
    }
    
    public  String retrieveAllBusNodes() {
        try (Session session = driver.session()) {
            return session.readTransaction(tx -> {
                Result result = tx.run("MATCH (n:Bus) RETURN n");
                StringBuilder stringBuilder = new StringBuilder();
                while (result.hasNext()) {
                    Record record = result.next();
                    Node node = record.get("n").asNode();
                    node.keys().forEach(key -> {
                        stringBuilder.append(key).append(": ").append(node.get(key)).append(", ");
                    });
                    stringBuilder.append("\n");
                }
                return stringBuilder.toString();
            });
        }
    }
    
    public void deleteBusNode(String matricul) {
        try (Session session = driver.session()) {
            session.writeTransaction(tx ->
                tx.run("MATCH (n:Bus {matricul: $matricul}) DELETE n",
                        parameters("matricul", matricul)));
        }
    }

    public void updateBusNode(String matricul, String newNbrePlace, String newNumero) {
        try (Session session = driver.session()) {
            session.writeTransaction(tx ->
                tx.run("MATCH (n:Bus {matricul: $matricul}) SET n.nbrePlace = $nbrePlace, n.numero = $numero",
                        parameters("matricul", matricul, "nbrePlace", newNbrePlace, "numero", newNumero)));
        }
    }

}
