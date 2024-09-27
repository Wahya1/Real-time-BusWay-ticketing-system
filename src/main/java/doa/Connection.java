import org.neo4j.driver.*;
import org.neo4j.driver.types.Node;

import static org.neo4j.driver.Values.parameters;

public class Connection {

    private static Connection instance;
    private static final String uri = "bolt://localhost:7687";
    private static final String user = "neo4j";
    private static final String password = "12345678";
    private final Driver driver;

    private Connection() {
        driver = GraphDatabase.driver(uri, AuthTokens.basic(user, password));
    }

    public static Connection getInstance() {
        if (instance == null) {
            instance = new Connection();
        }
        return instance;
    }

    public void close() {
        driver.close();
    }

    
    public static void main(String[]args)
    {
    	Connection cnt = getInstance();
    	System.out.println(cnt.retrieveAllBusNodes());
    }
    // Ajoutez les m�thodes updateBusNode et deleteBusNode pour la mise � jour et la suppression des n�uds BUS
}
