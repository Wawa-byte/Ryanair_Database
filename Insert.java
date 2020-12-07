/*
 * @author Waleed
 */

//Imports

import java.sql.*;

public class Insert {

    //Create new instance of insert class
    public Insert(){
    }

    public static void insertFlight(Connection conn, String bookingNo, String flightNo, String depature, String airport, String airplane, String passengerNo) {
        try {
            String insert = "INSERT INTO Flights VALUES(?, ?, ?, ?, ?, ?);";
            PreparedStatement pstmt = conn.prepareStatement(insert);
            pstmt.setString(1, bookingNo);
            pstmt.setString(2, flightNo);
            pstmt.setString(3, depature);
            pstmt.setString(4, airport);
            pstmt.setString(5, airplane);
            pstmt.setString(6, passengerNo);

            boolean rs = pstmt.execute();
            pstmt.close();
        }
        catch (Exception io) {
            System.out.println("Error" + io);
        }
    }
}
