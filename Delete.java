/*
 * @author Waleed 
 */

// Import
import java.sql.*;

public class Delete {

    //Creating a new class of Delete
    public Delete(){
    }

    public static void deleteFlight(Connection conn, String flightNo) {
        try {
            //Delete
            String delete = "DELETE FROM flights WHERE flightNo = (?);";
            PreparedStatement pstmt = conn.prepareStatement(delete);
            pstmt.setString(1, flightNo);
            boolean rs = pstmt.execute();
            pstmt.close();
        }
        catch (Exception io){
            System.out.println("Error" + io);
        }
    }
}
