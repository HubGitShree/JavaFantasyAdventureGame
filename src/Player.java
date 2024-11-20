import java.util.ArrayList;
import java.util.List;

class Player {
    Room currentRoom;
    List<String> inventory = new ArrayList<>();
    int health = 100;

    void move(String direction) {
        if (currentRoom.exits.containsKey(direction)) {
            currentRoom = currentRoom.exits.get(direction);
            System.out.println("You moved to: " + currentRoom.description);
        } else {
            System.out.println("You can't go that way!");
        }
    }

    void checkInventory() {
        System.out.println("Inventory: " + (inventory.isEmpty() ? "Empty" : inventory));
    }

    void addItem(String item) {
        inventory.add(item);
        System.out.println(item + " added to your inventory!");
    }
}
