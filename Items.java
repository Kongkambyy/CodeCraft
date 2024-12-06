public class Items {
    private int id;
    private String name;
    private double weight;
    private int value;
    private String type;

    public Items(int id, String name, double weight, int value, String type) {
        this.id = id;
        this.name = name;
        this.weight = weight;
        this.value = value;
        this.type = type;
    }
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public double getWeight() {
        return weight;
    }
    public int getValue() {
        return value;
    }
    public String getType() {
        return type;
    }
    public void setID(int id) {
        this.id = id;
    }
    public  void setName(String name) {
        this.name = name;
    }
    public  void setWeight(double Weight) {
        this.weight = weight;
    }
    public void setValue(int Value) {
        this.value = value;
    }
    public void setType(String type) {
        this.type = type;
    }
    @Override
    public String toString() {
        return "Itmems [id=" + id + ", name=" + name + ", weight=" + weight + ", value=" + value + "]";
    }
    public void displayItem(){
        System.out.println(this.id);
        System.out.println(this.name);
        System.out.println(this.weight);
        System.out.println(this.value);
        System.out.println(this.type);
    }
}
