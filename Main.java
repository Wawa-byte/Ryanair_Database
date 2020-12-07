/*
 * @author Waleed
 */

// Import functions
import java.sql.*;
import java.util.Scanner;

public class Main {

    // Runs a new instance of the Main class
    public Main(){
    }

    public static void main(String[] args) throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Ryanair?user=root&password=ryanairdata");
            System.out.println ("Database connection established");
            Statement s = conn.createStatement();

            //Simple Query
            ResultSet rs = s.executeQuery ("select * from Airline");
            while (rs.next ()) {
                String staffNoVal = rs.getString ("PassengerNo");
                System.out.println("PassengerNo is : "+staffNoVal);
            }
        }
        catch (Exception ex) {
            System.out.println("SQLException: " + ex.getMessage());
        }
        Scanner sc = new Scanner(System.in);
        while (true){
            System.out.println("\nPlease choose a number between 1 and 5");
            System.out.println("1. Show All Flights");
            System.out.println("2. Add flights");
            System.out.println("3. Remove Flight");
            System.out.println("4. Make a complaint");
            System.out.println("5. Exit");
            int scenario = sc.nextInt();

            switch (scenario){
                case 1:
                    Connection print_Conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/ryanair?user=root&password=ryanairdata");
                    System.out.println("The result of the statement");
                    Query print = new Query();
                    print.queryStatement(print_Conn);
                    break;
                case 2:
                    System.out.println("Adding in flights");
                    Scanner fl = new Scanner(System.in);
                    System.out.println("Booking Number (BI457)");
                    String bookingNo = fl.nextLine();
                    System.out.println("Flight Number (FR100)");
                    String flightNo = fl.nextLine();
                    System.out.println("Departure Time (1400)");
                    String departure = fl.nextLine();
                    System.out.println("Destination airport (Use Airport Code)");
                    String airport = fl.nextLine();
                    System.out.println("Airplane type (B737)");
                    String airplane = fl.nextLine();
                    System.out.println("Passenger Number (PNXXXXX)");
                    String passenger = fl.nextLine();
                    Connection insert_con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/ryanair?user=root&password=Waleedakhtar02");
                    Insert.insertFlight(insert_con, bookingNo, flightNo, departure, airport, airplane, passenger);
                    System.out.println("Flight Successfully added!");
                    break;
                case 3:
                    System.out.println("Removing the flights");
                    Scanner de = new Scanner(System.in);
                    System.out.println("Flight Number (FR100)");
                    String flightNum = de.nextLine();
                    Connection delete_con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/ryanair?user=root&password=Waleedakhtar02");
                    Delete.deleteFlight(delete_con, flightNum);
                    System.out.println("Flight Successfully deleted!");
                    break;
                case 4:
                    System.out.println("Making a complaint");
                    System.out.println("Please Enter your compliant below");
                    Scanner com = new Scanner(System.in);
                    String complaint = com.nextLine();
                    System.out.println("Sorry you had an unpleasant experience with Ryanair.");
                    System.out.println("We read all our complaints and take them very seriously");
                    System.out.println("We will try to get back to you as soon as we can for possible compensation");
            }
            if (scenario == 5) {
                System.out.println("Thank you for travelling with Ryanair. We hope you had a pleasant flight and looking forward to seeing you again soon");
                break;
            }

            else if (scenario > 5 || scenario < 1){
                System.out.println("Please enter a number between 1 and 5");
            }
        }
    }
}
