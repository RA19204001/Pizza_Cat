package dao;

//2.10 大川
import bean.Product;

public interface SideDao{

	public void addSide(bean.Product p);
	public Product getSide(String id);
	public Product editSide(String id, Product p);
	public Product getSideId(String name,String explanation);
	public void updateImage(String product_id);
}