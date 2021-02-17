//浅倉 2/17
package bean;

import java.util.ArrayList;

public class Cart implements Bean {
	private String name;
	private int price;
	private String id;
	private ArrayList option;
	private int amount;

	public Cart() {}



	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public ArrayList getOption() {
		return option;
	}

	public void setOption(ArrayList option) {
		this.option = option;
	}


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}





}
