package data.factory;

import com.github.javafaker.Faker;
import model.PlaceOrder;

import java.time.LocalDateTime;

import static builder.PlaceOrderRequestBuilder.createOrder;

public class OrderDataFactory {

    private static final Faker FAKER = new Faker();

    enum OrderStatus{
        PLACED, APPROVED, DELIVERED
    }

    public static PlaceOrder validOrder(){
        return createOrder()
                .withId(FAKER.number().randomNumber())
                .withPetId(FAKER.number().randomNumber())
                .withQuantity(FAKER.number().randomDigit())
                .withShipDate(LocalDateTime.now().toString())
                .withStatus(OrderStatus.PLACED.name())
                .withComplete(true)
                .build();
    }

    public static PlaceOrder validApprovedOrder(){
        return createOrder()
                .withId(FAKER.number().randomNumber())
                .withPetId(FAKER.number().randomNumber())
                .withQuantity(FAKER.number().randomDigit())
                .withShipDate(LocalDateTime.now().toString())
                .withStatus(OrderStatus.APPROVED.name())
                .withComplete(true)
                .build();
    }

    public static PlaceOrder validDeliveredOrder(){
        return createOrder()
                .withId(FAKER.number().randomNumber())
                .withPetId(FAKER.number().randomNumber())
                .withQuantity(FAKER.number().randomDigit())
                .withShipDate(LocalDateTime.now().toString())
                .withStatus(OrderStatus.DELIVERED.name())
                .withComplete(true)
                .build();
    }

    public static PlaceOrder incompleteOrder(){
        return createOrder()
                .withId(FAKER.number().randomNumber())
                .withPetId(FAKER.number().randomNumber())
                .withQuantity(FAKER.number().randomDigit())
                .withShipDate(LocalDateTime.now().toString())
                .withStatus(OrderStatus.PLACED.name())
                .withComplete(false)
                .build();
    }


}
