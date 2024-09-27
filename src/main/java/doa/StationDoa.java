import org.neo4j.driver.Record;
import org.neo4j.driver.Result;
import org.neo4j.driver.Session;
import org.neo4j.driver.types.Node;

import static org.neo4j.driver.Values.parameters;

public class StationDoa {

    public void createStationNode(String localname, double latitude, double longitude) {
        try (Session session = driver.session()) {
            session.writeTransaction(tx ->
                    tx.run("CREATE (n:Station {localname: $localname, latitude: $latitude, longitude: $longitude})",
                            parameters("localname", localname, "latitude", latitude, "longitude", longitude)));
        }
    }

    public String retrieveAllStationNodes() {
        try (Session session = driver.session()) {
            return session.readTransaction(tx -> {
                Result result = tx.run("MATCH (n:Station) RETURN n");
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

    public void deleteStationNode(String localname) {
        try (Session session = driver.session()) {
            session.writeTransaction(tx ->
                    tx.run("MATCH (n:Station {localname: $localname}) DELETE n",
                            parameters("localname", localname)));
        }
    }

    public void updateStationNode(String localname, double newLatitude, double newLongitude) {
        try (Session session = driver.session()) {
            session.writeTransaction(tx ->
                    tx.run("MATCH (n:Station {localname: $localname}) " +
                            "SET n.latitude = $latitude, n.longitude = $longitude",
                            parameters("localname", localname, "latitude", newLatitude, "longitude", newLongitude)));
        }
    }
}
