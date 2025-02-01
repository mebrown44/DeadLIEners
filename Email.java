import java.util.Scanner;

public class Email {
    private String user;
    private String domain;

    /*
    public static void main(String args[])
    {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Please enter your email!");
        Email object = new Email(myScanner.nextLine());

        System.out.println(object.user);
        System.out.println(object.domain);
    }
    */
    
    //Takes in full email as a string, split it into user and domain (domain starts at @)
    public Email(String s){
        
        if(validEmail(s)==true)
        {
            user = s.substring(0, s.indexOf("@"));
            domain = s.substring(s.indexOf("@"));
            //System.out.println("true");
        }

    }

    //Make sure email is valid, check if has valid domain
    public boolean validEmail(String s){
        
        String specialChars = "!#$%&'()*+,-/:;<=>?[]^_`{|}~";

        if(!(s.contains("@") && s.contains(".")))
        {
            return false;
        }
        for(int i =0; i < s.length(); i++)
        {
            if(specialChars.contains(String.valueOf(s.charAt(i))))
            {
                return false;
            }
        }
        return true;
    }

    public String getUserName()
    {
        return user;
    }
    
    /*
     * public void verifyEmail(){
     * //Optionally at the end, would send a quick message to email to verify it
     * }
     */
}