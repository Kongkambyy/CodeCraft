import java.sql.*;

public class Inv {
    double maxWeight = 50;
    private Item [] items = new Item[100];
    private String valg;


    public void deleteItem(int itemid) {
        boolean found = false;

        for (int i = 0 ; i < items.length ; i++){
            if (items[i].getId() == itemid){
                items[i] = null;
                found = true;
                System.out.println("Item med ID: " + itemid + " er blevet slettet.");
                break;
            }
        }
    }

    public void showInventory() {
        boolean inventoryFound = false;

        for (int i = 0 ; i < items.length ; i++){
            if (items[i] != null){
                items[i].displayItem();
            }
        }
    }

    public void addItem(Item item) {
        boolean added = false;

        for (int i = 0 ; i < items.length; i++){
            if (items[i] == null) {
                items[i] = item;
                added = true;
                System.out.println(item + " er blevet tilføjet til dit inventory.");
                break;
            }
        }
    }

    public void sort(int ii) {
        switch (ii){
            case 1:
                sortItemsById();
                showInventory();
                break;
            case 2:
                sortItemsByName();
                showInventory();
                break;
            case 3:
                sortItemsByWeight();
                showInventory();
                break;
            default:
                System.out.println("Det indtastede er ikke en mulighed");
        }
    }
    public void sortItemsByName() {
        int n = items.length; // Total length of the items array

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;

            // Find the index of the item with the smallest name lexicographically
            for (int j = i + 1; j < n; j++) {
                if (items[j] != null && items[minIndex] != null &&
                        items[j].getName().compareToIgnoreCase(items[minIndex].getName()) < 0) {
                    minIndex = j;
                }
            }

            // Swap the items to place the smallest name at the correct position
            if (minIndex != i && items[minIndex] != null && items[i] != null) {
                Item temp = items[minIndex];
                items[minIndex] = items[i];
                items[i] = temp;
            }
        }
    }


    public void sortItemsByWeight() {
        int n = items.length;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;

            // Ensure minIndex points to a non-null element
            while (minIndex < n && items[minIndex] == null) {
                minIndex++;
            }
            if (minIndex >= n) break; // If all remaining elements are null, exit the loop

            for (int j = i + 1; j < n; j++) {
                // Skip null elements and compare weights
                if (items[j] != null && items[minIndex] != null &&
                        items[j].getWeight() < items[minIndex].getWeight()) {
                    minIndex = j;
                }
            }

            // Swap elements if valid
            if (minIndex != i && items[minIndex] != null && items[i] != null) {
                Item temp = items[minIndex];
                items[minIndex] = items[i];
                items[i] = temp;
            }
        }
    }


    public void sortItemsById() {
        int n = items.length;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;

            // Ensure minIndex points to a non-null element
            while (minIndex < n && items[minIndex] == null) {
                minIndex++;
            }
            if (minIndex >= n) break; // If all remaining elements are null, exit the loop

            for (int j = i + 1; j < n; j++) {
                // Skip null elements in the comparison
                if (items[j] != null && items[minIndex] != null &&
                        items[j].getId() < items[minIndex].getId()) {
                    minIndex = j;
                }
            }

            // Swap elements if valid
            if (minIndex != i && items[minIndex] != null && items[i] != null) {
                Item temp = items[minIndex];
                items[minIndex] = items[i];
                items[i] = temp;
            }
        }
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
