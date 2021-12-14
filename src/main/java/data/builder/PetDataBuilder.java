package data.builder;

import com.github.javafaker.Faker;
import model.Category;
import model.Pet;
import model.TagsItem;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

import static builder.PetRequestBuilder.registerPet;

public class PetDataBuilder {

    private static final Faker FAKER = new Faker();

    enum PetStatus{
        AVAILABLE, PENDING, SOLD
    }

    private Pet pet;

    private void registerPetDefault() {
        pet = new Pet();
        Category category = new Category(FAKER.number().randomNumber(), FAKER.animal().name());
        TagsItem tagsItem = new TagsItem(FAKER.number().randomNumber(), FAKER.pokemon().location());

        this.pet = registerPet()
                .withId(FAKER.number().randomNumber())
                .withCategory(category)
                .withName(FAKER.cat().name())
                .withPhoto(List.of(FAKER.avatar().image()))
                .withTags(List.of(tagsItem))
                .withStatus(PetStatus.AVAILABLE.name())
                .build();
    }

    private PetDataBuilder() { registerPetDefault();}

    public static PetDataBuilder petDataBuilder() { return new PetDataBuilder(); }

    public PetDataBuilder withEmptyId() {
        this.pet.setId(0L);
        return this;
    }

    public PetDataBuilder withEmptyCategory() {
        this.pet.setCategory(null);
        return this;
    }

    public PetDataBuilder withEmptyName() {
        this.pet.setName(StringUtils.EMPTY);
        return this;
    }

    public PetDataBuilder withEmptyPhoto() {
        this.pet.setPhotoUrls(List.of(StringUtils.EMPTY));
        return this;
    }

    public PetDataBuilder withEmptyTags() {
        this.pet.setTags(List.of(null));
        return this;
    }

    public PetDataBuilder withEmptyStatus() {
        this.pet.setStatus(StringUtils.EMPTY);
        return this;
    }

    public PetDataBuilder withStatusAvailable() {
        this.pet.setStatus(PetStatus.AVAILABLE.name());
        return this;
    }

    public PetDataBuilder withStatusPending() {
        this.pet.setStatus(PetStatus.PENDING.name());
        return this;
    }

    public PetDataBuilder withStatusSold() {
        this.pet.setStatus(PetStatus.SOLD.name());
        return this;
    }
}
