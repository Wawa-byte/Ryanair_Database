/*
 * @author Waleed
 */

//Imports
import java.sql.*;

public class Query {

    // Create new Query
    public Query(){
    }

    public void queryStatement(Connection conn){
        try{
            Statement stmt = conn.createStatement();
            String qry = "SELECT * FROM Flights";
            ResultSet rs = stmt.executeQuery(qry);

            System.out.println("Flight Number, Departure Time, Destination airport, Airplane type, Passenger Number");
            while (rs.next()){
                System.out.print("" + rs.getString(2)); // Flight Number
                System.out.print("          " + rs.getString(3)); // Departure Time
                System.out.print("            " + rs.getString(4)); // Destination Airport
                System.out.print("                  " + rs.getString(5)); // Airplane Type
                System.out.print("           " + rs.getString(6)); // Passenger Number
                System.out.println();
                // The System.out.print are at different space lengths so when printing all the flights it looks neater
            }
            rs.close();
            stmt.close();
        }
        catch (Exception io){
            System.out.println("Error" + io);
        }
    }
}