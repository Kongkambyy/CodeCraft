import Exceptions.InventoryNotFoundException;
import Exceptions.ItemNotFoundException;

import java.sql.*;

public class Inv {
    double maxWeight = 50;
    private Item [] items = new Item[100];


    public void deleteItem(int itemid) throws ItemNotFoundException {
        boolean found = false;

        for (int i = 0 ; i < items.length ; i++){
            if (items[i].getId() == itemid){
                items[i] = null;
                found = true;
                System.out.println("Item med ID: " + itemid + " er blevet slettet.");
                break;
            }
        }

        if (!found){
            throw new ItemNotFoundException("Item med ID " + itemid + " blev ikke fundet i inventoriet.");
        }
    }

    public void showInventory() throws InventoryNotFoundException {
        boolean inventoryFound = false;

        for (int i = 0 ; i < items.length ; i++){
            if (items[i] != null){
                items[i].displayItem();
            }
        }

        if (!inventoryFound){
            throw new InventoryNotFoundException("Inventaret kunne ikke findes");
        }
    }

    public void addItem(Item item) throws ItemNotFoundException {
        boolean added = false;

        for (int i = 0 ; i < items.length; i++){
            if (items[i] == null) {
                items[i] = item;
                added = true;
                System.out.println(item + " er blevet tilføjet til dit inventory.");
                break;
            }
        }
        if (!added){
            throw new ItemNotFoundException("Item kunne ikke tilføjes.");
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
