package Exceptions;

public class InventoryNotFoundException extends Exception {
    // Standardkonstruktør
    public InventoryNotFoundException(String cause) {
        super(cause);
    }
}