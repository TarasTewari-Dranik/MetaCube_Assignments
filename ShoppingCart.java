package shoppingcart;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

class ShoppingCart {
	List<Item> shoppingCart= new ArrayList<Item>();
	
	public void addToCart(Item item, int quantity){
		if (quantity <=0){
			JOptionPane.showMessageDialog(null, "Quantity should be greater than 0");
		} else {
			item.setQuantity(quantity);
			shoppingCart.add(item);
		}
	}
	
	
    public  Integer displayQty(Item item){
    	Integer quantityInShoppingCart = null;
    	for (Item itemInShoppingCart:shoppingCart){
    		if (itemInShoppingCart.getItemID() == item.getItemID()){
    			quantityInShoppingCart = itemInShoppingCart.getQuantity();
    		} 
    	}
    	return quantityInShoppingCart;
	}
    
    public void updateQty(Item item, int quantity){
    	if (quantity <=0){
			JOptionPane.showMessageDialog(null, "Quantity should be greater than 0");
		} else {
	    	for (int i = 0; i < shoppingCart.size(); i++){
	    		if (shoppingCart.get(i).getItemID() == item.getItemID()){
	    			shoppingCart.get(i).setQuantity(quantity);
	    		} 
		    }
		}
	}
    
    public void deleteItem(Item item){
    	for (int i = 0; i < shoppingCart.size(); i++){
    		if (shoppingCart.get(i).getItemID()  == item.getItemID()){
    			shoppingCart.remove(i);
    		} 
    	}
	}
    
    public double displayBill(){
		Double sum=0.0;
		for (Item itemInShoppingCart:shoppingCart){
			sum =sum + itemInShoppingCart.getQuantity() * itemInShoppingCart.getPrice();
		}
		return sum;
	}

}
