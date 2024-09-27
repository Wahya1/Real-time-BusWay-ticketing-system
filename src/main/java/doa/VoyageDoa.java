import org.neo4j.driver.Record;
import org.neo4j.driver.Result;
import org.neo4j.driver.Session;
import org.neo4j.driver.types.Node;

import static org.neo4j.driver.Values.parameters;

public class VoyageDoa {

    public void createVoyageNode(String dateDepart, String dateArrivee) {
        try (Session session = driver.session()) {
            session.writeTransaction(tx ->
                    tx.run("CREATE (n:Voyage {date_depart: $dateDepart, date_arrivee: $dateArrivee})",
                            parameters("dateDepart", dateDepart, "dateArrivee", dateArrivee)));
        }
    }

    public String retrieveAllVoyageNodes() {
        try (Session session = driver.session()) {
            return session.readTransaction(tx -> {
                Result result = tx.run("MATCH (n:Voyage) RETURN n");
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

    public void deleteVoyageNode(String dateDepart, String dateArrivee) {
        try (Session session = driver.session()) {
            session.writeTransaction(tx ->
                    tx.run("MATCH (n:Voyage {date_depart: $dateDepart, date_arrivee: $dateArrivee}) DELETE n",
                            parameters("dateDepart", dateDepart, "dateArrivee", dateArrivee)));
        }
    }

    public void updateVoyageNode(String dateDepart, String dateArrivee, String newDateDepart, String newDateArrivee) {
        try (Session session = driver.session()) {
            session.writeTransaction(tx ->
                    tx.run("MATCH (n:Voyage {date_depart: $dateDepart, date_arrivee: $dateArrivee}) " +
                            "SET n.date_depart = $newDateDepart, n.date_arrivee = $newDateArrivee",
                            parameters("dateDepart", dateDepart, "dateArrivee", dateArrivee,
                                    "newDateDepart", newDateDepart, "newDateArrivee", newDateArrivee)));
        }
    }
}
