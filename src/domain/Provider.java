package domain;

public class Provider {

    private String name;
    private Credentials credentials;

    public Provider(String name, Credentials credentials) {
        this.name = name;
        this.credentials = credentials;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Credentials getCredentials() {
        return credentials;
    }

    public void setCredentials(Credentials credentials) {
        this.credentials = credentials;
    }

    @Override
    public String toString() {
        return this.name + " (" + super.toString() + ")";
    }
}
