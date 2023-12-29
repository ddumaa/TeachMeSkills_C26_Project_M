package course_project.storage;

public class StorageMock {

    private final String login = "5qk7jhrnladXNlcg=="; //encrypted with Base64 and salt. Original: user
    private final String password = "sjenzraa77Y2hhbmdlbWUxMjM="; //encrypted with Base64 and salt. Original: changeme123

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

}
