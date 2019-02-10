package shoppingcart;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.concurrent.atomic.AtomicInteger;

/* Item Object for the shopping cart*/

public class Item {
//	private static AtomicInteger uniqueId=new AtomicInteger(1000000000);
    private Integer itemID;
	private String  name;
	private String description;
	private Integer quantity;
	private Double price;

	public void setItem(int itemID, String  name,String description,Double price){
		/*this.itemID = uniqueId.getAndIncrement();*/
		this.itemID = itemID;
		this.name = name;
		this.description = description;
		this.price = price;
	}
	
	public void setItemID(Integer idOfItem) {
        this.itemID = idOfItem;
    }
	public void setQuantity(Integer amount) {
        this.quantity = amount;
    }
	
    public void setName(String nameOfItem) {
        this.name = nameOfItem;
    }
    
    public void setDescription(String descriptionOfItem) {
        this.description = descriptionOfItem;
    }
    
    public void setPrice(Double priceOfItem) {
        this.price = priceOfItem;
    }
    
	public Integer getItemID() {
        return itemID;
    }
	
	
	public Integer getQuantity() {
        return quantity;
    }
	
    public String getName() {
        return name;
    }
    
    public String getDescription() {
        return description;
    }
    
    public Double getPrice() {
        return price;
    }
    
    
}		
