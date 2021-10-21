package data.factory;

import com.github.javafaker.Faker;
import model.Category;
import model.Pet;
import model.TagsItem;

import java.util.Arrays;

import static builder.PetRequestBuilder.registerPet;

public class PetDataFactory {

    private static final Faker FAKER = new Faker();

    enum PetStatus{
        AVAILABLE, PENDING, SOLD
    }

    public static Pet availablePet(){
        Category category = new Category(FAKER.number().randomNumber(), FAKER.animal().name());
        TagsItem tagsItem = new TagsItem(FAKER.number().randomNumber(), FAKER.pokemon().location());

        return registerPet()
                .withId(FAKER.number().randomNumber())
                .withCategory(category)
                .withName(FAKER.cat().name())
                .withPhoto(Arrays.asList(FAKER.avatar().image()))
                .withTags(Arrays.asList(tagsItem))
                .withStatus(PetStatus.AVAILABLE.name()).build();
    }

    public static Pet pendingPet(){
        Category category = new Category(FAKER.number().randomNumber(), FAKER.animal().name());
        TagsItem tagsItem = new TagsItem(FAKER.number().randomNumber(), FAKER.pokemon().location());

        return registerPet()
                .withId(FAKER.number().randomNumber())
                .withCategory(category)
                .withName(FAKER.cat().name())
                .withPhoto(Arrays.asList(FAKER.avatar().image()))
                .withTags(Arrays.asList(tagsItem))
                .withStatus(PetStatus.PENDING.name()).build();
    }

    public static Pet soldPet(){
        Category category = new Category(FAKER.number().randomNumber(), FAKER.animal().name());
        TagsItem tagsItem = new TagsItem(FAKER.number().randomNumber(), FAKER.pokemon().location());

        return registerPet()
                .withId(FAKER.number().randomNumber())
                .withCategory(category)
                .withName(FAKER.cat().name())
                .withPhoto(Arrays.asList(FAKER.avatar().image()))
                .withTags(Arrays.asList(tagsItem))
                .withStatus(PetStatus.SOLD.name()).build();
    }
}
