package model;

public class Category{
	private String name;
	private long id;

	public Category(long id, String name) {
		this.id = id;
		this.name = name;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setId(long id){
		this.id = id;
	}

	public long getId(){
		return id;
	}
}
