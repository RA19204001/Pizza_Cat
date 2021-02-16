// 11時20分 いが
// 2/10 大川
package bean;

public class Product implements Bean{

	private String name;
	private String explanation;
	private String image;
	private  int price;
	private String productstype;
	private String product_id;
	private String product_display;
	private String product_category;
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


	public String getImage() {
		return image;
	}


	public void setImage(String image) {
		this.image = image;
	}


	public String getProductstype() {
		return productstype;
	}


	public void setProductstype(String productstype) {
		this.productstype = productstype;
	}


	public String getProduct_id() {
		return product_id;
	}


	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}


	public String getProduct_display() {
		return product_display;
	}


	public void setProduct_display(String product_display) {
		this.product_display = product_display;
	}


	public String getProduct_category() {
		return product_category;
	}


	public void setProduct_category(String product_category) {
		this.product_category = product_category;
	}

}
