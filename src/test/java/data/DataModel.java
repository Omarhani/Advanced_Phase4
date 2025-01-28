package data;

public class DataModel {
    public String URL;
    public Login Login;
    public ContactUs ContactUs;

    public static class Login {
        public String username;
        public String password;
    }

    public static class ContactUs {
        public String name;
        public String email;
        public String subject;
        public String message;
        public String filePath;
    }
}