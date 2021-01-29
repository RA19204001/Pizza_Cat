package dao;

import bean.Product;

public interface PizzaOptionDao
{

	public void addPizzaOption(bean.Product p);
	public Product getPizzaOption(String id);
	public Product editPizzaOption(String id, Product p);

}