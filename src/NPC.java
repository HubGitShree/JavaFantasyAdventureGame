// so the npc class will have a name and some dialogs,,lets create te fields etc for that
class NPC {
    String name;
    String dialog;
    String itemToGive;

    NPC(String name, String dialog, String itemToGive) {
        this.name = name;
        this.dialog = dialog;
        this.itemToGive = itemToGive;
    }

    String interact() {
        System.out.println(dialog);
        return itemToGive;
    }
}
