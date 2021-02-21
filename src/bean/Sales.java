//0221染谷
package bean;

import java.util.ArrayList;

public class Sales implements Bean {
	private ArrayList<Sale> saleList = new ArrayList<Sale>();

	public ArrayList<Sale> getSaleList() {
		return saleList;
	}

	public void setSaleList(ArrayList<Sale> saleList) {
		this.saleList = saleList;
	}


}
