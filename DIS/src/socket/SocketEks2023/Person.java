package socket.SocketEks2023;

public class Person {

    private String navn;
    private String by;
    private int id;

    public Person(int id, String navn, String by) {
        this.navn = navn;
        this.by = by;
        this.id = id;
    }

    public String getNavn() {
        return navn;
    }

    public String getBy() {
        return by;
    }

    public int getId() {
        return id;
    }
}
