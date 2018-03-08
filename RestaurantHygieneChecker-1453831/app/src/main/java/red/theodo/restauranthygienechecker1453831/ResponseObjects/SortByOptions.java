package red.theodo.restauranthygienechecker1453831.ResponseObjects;

/**
 * Created by theo on 07/03/18.
 */

public class SortByOptions {
    private String name;
    private String key;
    private int id;

    public SortByOptions(String name, String key, int id) {
        this.name = name;
        this.key = key;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getKey() {
        return key;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
