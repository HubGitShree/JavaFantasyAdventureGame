import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Room {
    String description;
    Map<String, Room> exits = new HashMap<>();
    List<String> items = new ArrayList<>();

    Room(String description) {
        this.description = description;
    }

    void setExit(String direction, Room room) {
        exits.put(direction, room);
    }
}
