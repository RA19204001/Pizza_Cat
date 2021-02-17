package dao;

import java.util.ArrayList;

import bean.Product;

public interface PizzaOptionDao
{

	public void addPizzaOption(bean.Product p);
	public ArrayList getPizzaOption();
	public Product editPizzaOption(String id, Product p);

}