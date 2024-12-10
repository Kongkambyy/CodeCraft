import java.sql.*;

public class Inv {
    double maxWeight = 50;
    private Item [] items = new Item[100];

    public void deleteItem(int itemid) {
        for (int i = 0 ; i < items.length ; i++){
            if (items[i].getId() == itemid){
                items[i] = null;
            }
        }
    }

    public void showInventory(){
        for (int i = 0 ; i < items.length ; i++){
            if (items[i] != null){
                items[i].displayItem();
            }
        }
    }

    public void addItem(Item item){
        for (int i = 0 ; i < items.length; i++){
            if (items[i] == null){
                items[i] = item;
                break;
            }
        }

    }


    public void sortItems (){
        //Selection sort
    }

    public String convertWholeInvToString(){
        String output = "";

        for (int i = 0 ; i < items.length ; i++){
            if (items[i] != null){
                output += items[i].convertItemToString() + "#";
            }
        }
        return output;
    }

}
