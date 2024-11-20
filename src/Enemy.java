class Enemy {
    String name;
    int health;
    int attackPower;

    Enemy(String name, int health, int attackPower) {
        this.name = name;
        this.health = health;
        this.attackPower = attackPower;
    }

    int attack() {
        return attackPower;
    }

    void takeDamage(int damage) {
        health -= damage;
        System.out.println(name + " takes " + damage + " damage. Remaining health: " + health);
    }
}
