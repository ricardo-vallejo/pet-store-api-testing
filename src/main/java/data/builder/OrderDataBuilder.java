package data.builder;

import com.github.javafaker.Faker;
import model.PlaceOrder;
import org.apache.commons.lang3.StringUtils;

import java.time.LocalDateTime;

import static builder.PlaceOrderRequestBuilder.createOrder;

public class OrderDataBuilder {

    private static final Faker FAKER = new Faker();

    enum OrderStatus {
        PLACED, APPROVED, DELIVERED
    }

    private PlaceOrder placeOrder;

    private void orderDefault() {
        placeOrder = new PlaceOrder();
        this.placeOrder = createOrder()
                .withId(FAKER.number().randomNumber())
                .withPetId(FAKER.number().randomNumber())
                .withQuantity(FAKER.number().randomDigit())
                .withShipDate(LocalDateTime.now().toString())
                .withStatus(OrderStatus.APPROVED.name())
                .withComplete(true)
                .build();
    }

    private OrderDataBuilder() { orderDefault(); }

    public static OrderDataBuilder orderDataBuilder() { return new OrderDataBuilder(); }

    public OrderDataBuilder withEmptyId() {
        this.placeOrder.setId(0L);
        return this;
    }

    public OrderDataBuilder withEmptyPetId() {
        this.placeOrder.setPetId(0L);
        return this;
    }

    public OrderDataBuilder withEmptyQuantity() {
        this.placeOrder.setQuantity(0);
        return this;
    }

    public OrderDataBuilder withEmptyShipDate() {
        this.placeOrder.setShipDate(StringUtils.EMPTY);
        return this;
    }

    public OrderDataBuilder withEmptyStatus() {
        this.placeOrder.setStatus(StringUtils.EMPTY);
        return this;
    }

    public OrderDataBuilder withEmptyComplete() {
        this.placeOrder.setComplete(false);
        return this;
    }

    public OrderDataBuilder withStatusApproved() {
        this.placeOrder.setStatus(OrderStatus.APPROVED.name());
        return this;
    }

    public OrderDataBuilder withStatusPlaced() {
        this.placeOrder.setStatus(OrderStatus.PLACED.name());
        return this;
    }

    public OrderDataBuilder withStatusDelivered() {
        this.placeOrder.setStatus(OrderStatus.DELIVERED.name());
        return this;
    }
}
