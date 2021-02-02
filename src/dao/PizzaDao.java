// 2/2 16;00 内田
package dao;

import java.util.ArrayList;

import bean.Product;

public interface PizzaDao{

	public void addPizza(bean.Product p);
	public ArrayList getPizza();
	public Product editPizza(String id, Product p);

}