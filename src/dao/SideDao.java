//0220
package dao;

import java.util.ArrayList;

//2.10 大川
//2/12 大川
import bean.Product;

public interface SideDao{

	public void addSide(bean.Product p);
	public ArrayList getSide();
	public void editSide(String id, Product p);
	public Product getSideId(String name,String explanation);
	public void updateSideImage(String product_id);
	public void editDisplaySide(String id, Product product);
}