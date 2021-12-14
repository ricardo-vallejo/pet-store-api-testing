package model;

public class PlaceOrder{
	private long petId;
	private int quantity;
	private long id;
	private String shipDate;
	private boolean complete;
	private String status;

	public void setPetId(long petId){
		this.petId = petId;
	}

	public long getPetId(){
		return petId;
	}

	public void setQuantity(int quantity){
		this.quantity = quantity;
	}

	public int getQuantity(){
		return quantity;
	}

	public void setId(long id){
		this.id = id;
	}

	public long getId(){
		return id;
	}

	public void setShipDate(String shipDate){
		this.shipDate = shipDate;
	}

	public String getShipDate(){
		return shipDate;
	}

	public void setComplete(boolean complete){
		this.complete = complete;
	}

	public boolean isComplete(){
		return complete;
	}

	public void setStatus(String status){
		this.status = status;
	}

	public String getStatus(){
		return status;
	}
}
