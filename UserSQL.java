import java.sql.*;

public class UserSQL {
    private static final String URL = "postgresql://postgres:Pupp!esr0ck@localhost:5432/users";
    private static final String USER = "postgre";
    private static final String PASSWORD = "Pupp!esr0ck";

    public UserSQL(){

    }

    public void insertUser(User u){
        String sql = "INSERT INTO userCreds (Email, Passkey, userCalender) VALUES (?, ?, ?)";

        try(Connection conn = DriverManager.getConnection(URL, USER, PASSWORD); PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setString(1, u.getUsername());
            pstmt.setString(2, u.getPasskey());
            pstmt.setObject(3, u.getEvents());

            pstmt.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
