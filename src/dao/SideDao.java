package dao;

import bean.Product;

public interface SideDao{

	public void addSide(bean.Product p);
	public Product getSide(String id);
	public Product editSide(String id, Product p);


}