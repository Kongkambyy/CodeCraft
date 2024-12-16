abstract class Item {
    private int id;
    private String name;
    private int weight;
    private int value;

    public Item(int id, String name, int weight, int value) {
        this.id = id;
        this.name = name;
        this.weight = weight;
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    public int getValue() {
        return value;
    }

    public void setID(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setWeight(int weight) {
        this.weight = weight;
    }
    public void setValue(int value) {
        this.value = value;
    }


    @Override
    public String toString() {
        return "Items [id=" + id + ", name=" + name + ", weight=" + weight + ", value=" + value + "]";
    }

    public void displayItem() {
        System.out.println(" _________________");
        System.out.println(" | Name  : " + this.name);
        System.out.println(" | ItemID: " + this.id);
        System.out.println(" | Weight: " + this.weight + " KG");
        System.out.println(" | Value : " + this.value);
        System.out.println(" _________________");
    }
}
