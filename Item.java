public class Item {
    private int id;
    private String name;
    private int weight;
    private int value;
    private String type;

    String [] weapons = {"Sword", "Axe", "Spear", "Shield", "Dagger"};
    String [] Armors = {"HeadArmor", "ChestArmor", "LegArmor", "FootArmor"};
    String [] Consumable = {"Healing Potin", "Damage Potion", "Arrow"};

    public Item(int id, String name, int weight, int value, String type) {
        this.id = id;
        this.name = name;
        this.weight = weight;
        this.value = value;
        this.type = type;
    }
    public Item(){}

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

    public String getType() {
        return type;
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

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Itmems [id=" + id + ", name=" + name + ", weight=" + weight + ", value=" + value + "]";
    }

    public void displayItem() {
        System.out.println("Name: " + this.name);
        System.out.println("Type: " + this.type);
        System.out.println("ID: " + this.id);
        System.out.println("Weight: " + this.weight);
        System.out.println("Value: " + this.value);
    }

    public Item convertStringToItem(String s) {

        Item thisItem = new Item(0, "", 0, 0, "");

        //Bestem type
        int typeCode = s.charAt(0) - '0';
        //bestemmer ud fra index 0 i strengen hvilke type thisItem er
        switch (typeCode) {
            case 0: thisItem.setType("Weapon"); break;
            case 1: thisItem.setType("Armor"); break;
            case 2: thisItem.setType("Consumable"); break;
            default:
        }

        // Sæt ID ud fra index 1 og 2 i S.
        thisItem.setID((s.charAt(1) - '0') * 10 + (s.charAt(2) - '0'));
        thisItem.setWeight((s.charAt(3) - '0') * 10 + (s.charAt(4) - '0'));
        thisItem.setValue((s.charAt(5) - '0') * 100 + (s.charAt(6) - '0') * 10 + (s.charAt(7) - '0'));

        //Bruger index 8 til at vælge hvilket array der skal søges i
        int nameIndex = s.charAt(8) - '0';

        //Bruger typeCode (index 0) fra forrige step til at vælge mellem array
        switch (typeCode) {
            //bruger nameIndex (index 8) til at vælge navnet i arrayet der allerede er blevet valgt
            case 0:
                thisItem.setName(weapons[nameIndex]);
                break;
            case 1:
                thisItem.setName(Armors[nameIndex]);
                break;
            case 2:
                thisItem.setName(Consumable[nameIndex]);
                break;
            default:
        }
        return thisItem;
    }

    public String convertItemToString() {
        char[] chars = new char[9];

        switch (getType()) {
            case "Weapon": chars[0] = '0'; break;
            case "Armor": chars[0] = '1'; break;
            case "Consumable": chars[0] = '2'; break;
            default:
        }

        String id = String.format("%02d", (int) getId());
        chars[1] = id.charAt(0);
        chars[2] = id.charAt(1);

        String weight = String.format("%02d", (int) getWeight());
        chars[3] = weight.charAt(0);
        chars[4] = weight.charAt(1);

        String value = String.format("%03d", (int) getValue());
        chars[5] = value.charAt(0);
        chars[6] = value.charAt(1);
        chars[7] = value.charAt(2);

        int nameIndex = -1;
        String[] array = null;

        switch (getType()) {
            case "Weapon": array = weapons; break;
            case "Armor": array = Armors; break;
            case "Consumable": array = Consumable; break;
        }

        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(getName())) {
                nameIndex = i;
                break;
            }
        }

        if (nameIndex == -1) {
            throw new IllegalArgumentException("Name not found in the array.");
        }

        chars[8] = (char) (nameIndex + '0');

        return new String(chars);
    }

}
