public class Cargo {
    // Parameter
    String name;
    int amount;

    // Constructor
    Cargo() {
    }

    Cargo(String name, int amount) {
        this.name = name;
        this.amount = amount;
    }

    // Getter & Setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String toString() {
        return name + "{amount='" + amount + '\'' + '}';
    }

    // Methods

}
