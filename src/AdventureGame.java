import java.util.*;
// I have gone for the Steppenwolf  inspired world building.
// NPC ( non-playable character ) : wise old wizard
//  enemy is the goblin

public class AdventureGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        Room entrance = new Room("Entrance of the dungeon.");
        Room forest = new Room("A dark, eerie forest.");
        Room dungeon = new Room("A scary dungeon with flickering torches.");
        Room treasureRoom = new Room("The Treasure Room! You see a glittering chest.");

        entrance.setExit("north", forest);
        forest.setExit("south", entrance);
        forest.setExit("east", dungeon);
        dungeon.setExit("west", forest);
        dungeon.setExit("north", treasureRoom);

        // Adding  items to rooms
        forest.items.add("Key");
        dungeon.items.add("Potion");


        NPC wiseMan = new NPC("Wise Man", "The key is in the forest. Find it to unlock your treasure!", "Hint");
        Enemy goblin = new Enemy("Goblin", 50, 10);


        Player player = new Player();
        player.currentRoom = entrance;


        System.out.println("Welcome to the Adventure Game!");
        System.out.println("In the Text-Based Adventure Game, your goal is to explore rooms, collect items, interact with NPCs, and battle enemies to unlock the treasure in the Treasure Room.\nUse commands like go [direction] to navigate, check inventory to view your items, collect to pick up items, talk to interact with NPCs, and attack to fight enemies.\nReach the treasure without losing all your health to win the game.");
        while (player.health > 0) {
            System.out.println("\nYou are in: " + player.currentRoom.description);
            System.out.println("Available commands: go [direction], check inventory, talk, attack, run");
            System.out.println("Items in room: " + player.currentRoom.items);

            String command = scanner.nextLine();

            if (command.startsWith("go ")) {
                String direction = command.substring(3);
                player.move(direction);
            } else if (command.equals("check inventory")) {
                player.checkInventory();
            } else if (command.equals("talk") && player.currentRoom == forest) {
                String item = wiseMan.interact();
                if (item != null) player.addItem(item);
            } else if (command.equals("attack") && player.currentRoom == dungeon) {
                while (goblin.health > 0 && player.health > 0) {
                    goblin.takeDamage(20);
                    if (goblin.health <= 0) {
                        System.out.println("You defeated the goblin!");
                        break;
                    }
                    player.health -= goblin.attack();
                    System.out.println("Goblin attacks! Your health: " + player.health);
                }
                if (player.health <= 0) {
                    System.out.println("You died! Game Over.");
                    break;
                }
            } else if (command.equals("run") && player.currentRoom == dungeon) {
                System.out.println("You ran away from the goblin!");
                player.move("west");
            } else if (command.equals("collect")) {
                if (!player.currentRoom.items.isEmpty()) {
                    String item = player.currentRoom.items.remove(0);
                    player.addItem(item);
                } else {
                    System.out.println("No items to collect here.");
                }
            } else {
                System.out.println("Invalid command!");
            }

            // If player has the key and is in the treasure room, they win the game
            if (player.currentRoom == treasureRoom && player.inventory.contains("Key")) {
                System.out.println("You unlocked the treasure and won the game! Congratulations!");
                break;
            }
        }
        scanner.close();
    }
}

