import java.sql.*;

public class CalenderSQL {
    private String user;
    private String passkey;
    private Calender c;

    public CalenderSQL(){

    }

    public void insertUser(){
        String sql = "INSERT INTO userCreds (Email, Passkey, userCalender) VALUES (?, ?, ?)";

        try(Connection conn = DriverManager.getConnection(user, passkey, c))
    }
}
