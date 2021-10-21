package builder;

import model.PlaceOrder;

public class PlaceOrderRequestBuilder {

    private final PlaceOrder placeOrder;

    private PlaceOrderRequestBuilder(){
        placeOrder = new PlaceOrder();
    }

    public PlaceOrderRequestBuilder createOrder(){
        return new PlaceOrderRequestBuilder();
    }

    public PlaceOrderRequestBuilder withId(int id){
        this.placeOrder.setId(id);
        return this;
    }

    public PlaceOrderRequestBuilder withPetId(int petId){
        this.placeOrder.setPetId(petId);
        return this;
    }

    public PlaceOrderRequestBuilder withQuantity(int quantity){
        this.placeOrder.setQuantity(quantity);
        return this;
    }

    public PlaceOrderRequestBuilder withShipDate(String shipDate){
        this.placeOrder.setShipDate(shipDate);
        return this;
    }

    public PlaceOrderRequestBuilder withStatus(String status){
        this.placeOrder.setStatus(status);
        return this;
    }

    public PlaceOrderRequestBuilder withComplete(boolean complete){
        this.placeOrder.setComplete(complete);
        return this;
    }

    public PlaceOrder build(){
        return placeOrder;
    }
}
