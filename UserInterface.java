package shoppingcart;

import javax.swing.JOptionPane;

// User Interface for the shopping cart

class UserInterface {

    ShoppingCart cart = new ShoppingCart();
    private Integer choice;

    public UserInterface() {
        menu();
    }

    private int getUserInput() {
        String[] action = { "1.Add Item to the Cart", 
                            "2.Update Quantity", 
                            "3.Display Item Quantity In The Cart",
                            "4.Delete Item", 
                            "5.Show Total", 
                            "6.Exit" };
        String whatToDo = (String) JOptionPane.showInputDialog(null, "What do you want to do?", "Action",JOptionPane.QUESTION_MESSAGE, null, action, action[0]);
        choice = Character.getNumericValue(whatToDo.charAt(0));
        return choice;

    }

    public void menu() {
        do {
            getUserInput();
            switch (choice) {
            case 1:
                addItemToTheCart();
                break;
            case 2:
                updateQuantity();
                break;
            case 3:
                displayItemQuantityInTheCart();
                break;
            case 4:
                deleteItem();
                break;
            case 5:
                showTotal();
                break;
            case 6:
                System.exit(0);
                break;
            default:
                break;
            }
        } while (choice != 0);
    }

    private void addItemToTheCart() {
        Item newItem = new Item();
        String idInput = JOptionPane.showInputDialog("Provide Item ID (Unique Integer Number)");
        int itemID = Integer.parseInt(idInput);
        String nameInput = JOptionPane.showInputDialog("Provide Name");
        String descriptionInput = JOptionPane.showInputDialog("Provide Description");
        String priceInput = JOptionPane.showInputDialog("Provide Price");
        double price = Double.parseDouble(priceInput);
        newItem.setItem(itemID, nameInput, descriptionInput, price);
        String quantityInput = JOptionPane.showInputDialog("Provide Quantity (Integer Number Greater than 0)");
        int quantity = Integer.parseInt(quantityInput);
        cart.addToCart(newItem, quantity);
    }

    private void updateQuantity() {
        Item updateItem = new Item();
        String itemIdToUpdateInput = JOptionPane.showInputDialog("Provide Item ID In The Cart To Update Quantity");
        int itemIdToUpdate = Integer.parseInt(itemIdToUpdateInput);
        updateItem.setItemID(itemIdToUpdate);
        String newQuantityInput = JOptionPane.showInputDialog("Provide New Quantity (Integer Number Greater than 0)");
        int newQuantity = Integer.parseInt(newQuantityInput);

        cart.updateQty(updateItem, newQuantity);
    }

    private void displayItemQuantityInTheCart() {
        Item displayItem = new Item();
        String itemIdToDisplayInput = JOptionPane.showInputDialog("Provide ID Of The Item Which You Want To See");
        int itemIdToDisplay = Integer.parseInt(itemIdToDisplayInput);
        displayItem.setItemID(itemIdToDisplay);
        int amount = cart.displayQty(displayItem);
        JOptionPane.showMessageDialog(null, "The quantity is " + amount);
    }

    private void deleteItem() {
        Item itemToDelete = new Item();
        String itemIdToDeleteInput = JOptionPane.showInputDialog("Provide ID Of The Item Which You Want To Delete");
        int itemIdToDelete = Integer.parseInt(itemIdToDeleteInput);
        itemToDelete.setItemID(itemIdToDelete);
        cart.deleteItem(itemToDelete);
    }

    private void showTotal() {
        double total = cart.displayBill();
        JOptionPane.showMessageDialog(null, "The Total Price Of Your Order " + total);
    }
}
