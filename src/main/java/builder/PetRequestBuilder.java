package builder;

import model.Category;
import model.Pet;
import model.TagsItem;

import java.util.List;

public class PetRequestBuilder {

    private final Pet pet;

    private PetRequestBuilder(){
        pet = new Pet();
    }

    public PetRequestBuilder registerPet(){
        return new PetRequestBuilder();
    }

    public PetRequestBuilder withId(int id){
        this.pet.setId(id);
        return this;
    }

    public PetRequestBuilder withCategory(Category category){
        this.pet.setCategory(category);
        return this;
    }

    public PetRequestBuilder withName(String name){
        this.pet.setName(name);
        return this;
    }

    public PetRequestBuilder withPhoto(List<String> photo){
        this.pet.setPhotoUrls(photo);
        return this;
    }

    public PetRequestBuilder withTags(List<TagsItem> tags){
        this.pet.setTags(tags);
        return this;
    }

    public PetRequestBuilder withStatus(String status){
        this.pet.setStatus(status);
        return this;
    }

    public Pet build(){
        return pet;
    }
}
