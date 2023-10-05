package Game2023MAC.game;

public class Treasure {
    private pair location;
    private int id;
    private static int counter = 1;

    public Treasure(pair location) {
        this.location = location;
    }

    public pair getLocation() {
        return location;
    }

    public int getId() {
        return id;
    }

    public void createID() {
        this.id = counter;
        counter++;
    }

    public void setId(int id) {
        this.id = id;
    }
}


