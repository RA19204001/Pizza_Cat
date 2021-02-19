package bean;

import java.util.ArrayList;

public class Receipt implements Bean {
	private ArrayList list;
	private String total;

	public Receipt() {}
	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}


	public ArrayList getList() {
		return list;
	}

	public void setList(ArrayList list) {
		this.list = list;
	}
}


