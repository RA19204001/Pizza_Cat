package dao;

import bean.Product;

public interface PizzaDao{

	public void addPizza(bean.Product p);
	public Product getPizza(String id);
	public Product editPizza(String id, Product p);

}