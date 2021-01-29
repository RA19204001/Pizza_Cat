package bean;

public class Product implements Bean{
	private String name;
	private String explanation;
	private  int price;
	public Product() {}


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}


	public String getExplanation() {
		return explanation;
	}


	public void setExplanation(String explanation) {
		this.explanation = explanation;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}

}
