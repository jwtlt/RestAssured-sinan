package utitlities;


import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import static io.restassured.RestAssured.baseURI;

public abstract class HRTestBase {
    @BeforeAll
    public static void init(){
        //save baseurl inside this variable so that we don't need to type each http method.
        baseURI = "http://54.205.239.177:1000/ords/hr";

        //get ip address from configurations
        String dbUrl = "jdbc:oracle:thin:@54.205.239.177:1521:xe";
        String dbUsername = "hr";
        String dbPassword = "hr";

        //  DBUtils.createConnection(dbUrl,dbUsername,dbPassword);
    }

    @AfterAll
    public static void teardown(){

        //DBUtils.destroy();
    }
}
