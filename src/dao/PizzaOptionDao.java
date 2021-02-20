//0220
package dao;

import java.util.ArrayList;

import bean.Product;

public interface PizzaOptionDao
{

	public void addPizzaOption(bean.Product p);
	public ArrayList getPizzaOption();
	public ArrayList getHidePizzaOption();
	public void editPizzaOption(String id, Product p);
	public void editDisplayPizzaOption(String id, Product p);

}
