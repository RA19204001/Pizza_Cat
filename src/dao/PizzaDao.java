// 2/2 16;00 内田
//2/12 大川
//2.10 大川
//0220
package dao;

import java.util.ArrayList;

import bean.Product;

public interface PizzaDao{

	public void addPizza(bean.Product p);
	public ArrayList getPizza();
	public void editPizza(String id, Product p);
	public Product getPizzaId(String name,String explanation);
	public void updatePizzaImage(String product_id);
	public void editDisplayPizza(String product_id, Product p);
}