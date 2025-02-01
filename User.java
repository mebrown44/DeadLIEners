import java.io.*;
import java.util.*;

public class User{
    private Email username;
    private int passkey;
    private Calender userCalender;
    private Scanner keyboard;

    //Take in the sign in information and write it into a file
    public User(Email u, int p){
        username = u;
        passkey = p;

        userCalender = new Calender();
    }

    //Default constructor, just so it doesn't error out, doesn't need much code
    public User(String u, String p){
        username = new Email(u);
        passkey = Integer.parseInt(p);

        while (passkey > 9999 || passkey < 1000){
            System.out.println("Enter a 4 digit passcode: ");

        }
    }
}