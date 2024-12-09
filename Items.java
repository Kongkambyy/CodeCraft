public class Item {
    private int id;
    private String name;
    private double weight;
    private int value;
    private String type;

    String [] weapons = {"Sword", "Axe", "Spear", "Shield", "Dagger"};
    String [] Armors = {"HeadArmor", "ChestArmor", "LegArmor", "FootArmor"};
    String [] Consumable = {"Healing Potin", "Damage Potion", "Arrow"};

    public Item(int id, String name, double weight, int value, String type) {
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

    public void setName(String name) {
        this.name = name;
    }

    public void setWeight(double Weight) {
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

    public void displayItem() {
        System.out.println(this.id);
        System.out.println(this.name);
        System.out.println(this.weight);
        System.out.println(this.value);
        System.out.println(this.type);
    }

    public Item convertStringToItem(String s) {
        Item thisItem = new Item(0, s, 0, 0, "");

        //Bruger index 0 til at bestemme typen på item
        switch (s.charAt(0) - '0') {
            case '0':
                thisItem.setType("Weapon");
                break;
            case '1':
                thisItem.setType("Armor");
                break;
            case '2':
                thisItem.setType("Consumable");
                break;
            default:
                InvalidItemTypeException
        }

        // Giver item et id fra index 1 og 2 i String s
        thisItem.setID((s.charAt(1) - '0') * 10 +(s.charAt(2) - '0'));

        // Giver item en vægt ud fra værdierne på index 3 og 4 i String s
        thisItem.setWeight((s.charAt(3) - '0') * 10 +(s.charAt(4) - '0'));

        // Giver item en value ud fra index 5, 6, 7 i String s. Disse værdier kan have forskellige meninger alt efter om item er et weapon(Damage), Armor (health), Consumable (impact)
        thisItem.setValue((s.charAt(5)- '0') * 100 + (s.charAt(6) - '0' )* 10 + (s.charAt(7) - '0'));

        //Lister med navne på de forskellige Items. Her må maksimalt være 10 af hvert Item i listen. Ellers skal der dedikeres en char mere til det i String S


        // bruger værdien på index 0 til at bestemme hvad der skal gøres. 0 = weapon, 1 = Armor, 2 = Consumable
        switch (s.charAt(0)){
            // hvis index 0 = 0 (weapon) bruger den index 8 til at vælge hvad navnet er ud fra weapon array
            case '0':
                thisItem.setName(weapons[s.charAt(8)]);
                break;

            case '1':
                thisItem.setName(Armors[s.charAt(8)]);
                break;

            case '2':
                thisItem.setName(Consumable[s.charAt(8)]);
                break;
            default:
                ItemNameNotFoundException;
                break;
        }
        return thisItem;
    }

    public String convertItemToString(Item i) {

        char [] chars = new char[7];

        switch (i.getType()){
            case "Weapon":
                chars[0] = '0';
                break;
            case "Armor":
                chars[0] = '1';
                break;
            case "Consumable":
                chars[0] = '2';
                break;
        }

        String id = String.valueOf(i.getId());
        if (id.length() == 1){
            id = "0" + String.valueOf(i.getId());
        }
        chars[1] = id.charAt(0);
        chars[2] = id.charAt(1);

        String weight = String.valueOf(i.getWeight());
        chars[3] = weight.charAt(0);
        chars[4] = weight.charAt(1);

        String value = String.valueOf(i.getValue());
        if (value.length() == 1){
            value = "00" + String.valueOf(i.getValue());
        } else if (value.length() == 2){
            value = "0" + String.valueOf(i.getValue());
        }
        chars[5] = value.charAt(0);
        chars[6] = value.charAt(1);
        chars[7] = value.charAt(2);

        String arrayNameFinder = i.getName();
        switch (arrayNameFinder){
            case "Weapon":
                for (int w = 0 ; w < weapons.length ; w++){
                    if (weapons[w].equals(arrayNameFinder)){
                        chars[8] = (char) (w + '0');
                    }
                }
                break;
            case "Armor":
                for (int a = 0 ; a < Armors.length ; a++){
                    if (Armors[a].equals(arrayNameFinder)){
                        chars[8] = (char) (a + '0');
                    }
                }
                break;
            case "Consumable":
                for (int c = 0 ; c < Consumable.length ; c++){
                    if (Consumable[c].equals(arrayNameFinder)){
                        chars[8] = (char) (c + '0');
                    }
                }
                break;
        }
        return new String(chars);



    }
}
