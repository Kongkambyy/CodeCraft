import java.sql.*;

public class Inv {
    double maxWeight = 50;
    private Items [] items;

    public void deleteItem(int itemid) {
        for (int i = 0 ; i < items.length ; i++){
            if (items[i].getId() == itemid){
                items[i] = null;
            }
        }
    }

    public void showInventory(){
        for (int i = 0 ; i < items.length ; i++){
            items[i].displayItem();
        }
    }

    public void addItem(Items item){
        for (int i = 0 ; i < items.length ; i++){
            if (items[i] == null && maxWeight + item.getWeight() <= maxWeight){
                items[i] = item;
                break;
            }
        }
    }

    public Items[] getItems() {
        return items;
    }

    public void sortItems (){
        //Selection sort
    }

}
