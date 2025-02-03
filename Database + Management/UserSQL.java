import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.events.Event;

public class UserSQL {
    private static final String URL = "jdbc:postgresql://localhost:5432/users";
    private static final String USER = "postgres";
    private static final String PASSWORD = "Pupp!esr0ck";

    public UserSQL(){
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

     // Function to call addUser(username, passkey)
    public static void addUser(Connection conn, User user) {
        String sql = "SELECT addUser(?, ?)"; // Call PostgreSQL function

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getPasskey());
            stmt.execute();
            System.out.println("User added successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Function to retrieve user calendar as a List of Event objects
    public static List<Event> retrieveUser(Connection conn, String username, String passkey) {
        String sql = "SELECT retrieveUser(?, ?)"; // Call PostgreSQL function
        List<Event> events = new ArrayList<>();

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, username);
            stmt.setString(2, passkey);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Array eventArray = rs.getArray(1); // Retrieve array from PostgreSQL
                if (eventArray != null) {
                    Object[] eventData = (Object[]) eventArray.getArray();
                    for (Object eventObj : eventData) {
                        String eventStr = eventObj.toString(); // Format: (event_name,event_date)
                        eventStr = eventStr.replace("(", "").replace(")", ""); 
                        String[] parts = eventStr.split(",");
                        if (parts.length == 2) {
                            events.add(new Event(parts[0], Date.valueOf(parts[1])));
                        }
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return events;
    }

    public static void main (String[] args){
        new UserSQL();
    }

    /*public void insertUser(User u){
        String sql = "INSERT INTO userCreds (Email, Passkey, userCalender) VALUES (?, ?, ?)";

        try(Connection conn = DriverManager.getConnection(URL, USER, PASSWORD); PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setString(1, u.getUsername());
            pstmt.setString(2, u.getPasskey());
            pstmt.setObject(3, u.getEvents());

            pstmt.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
    } */
}
