
package bean;

import java.util.ArrayList;

public class AddresseeList implements Bean {

	private ArrayList<Addressee> addresseeList = new ArrayList<Addressee>();

	public ArrayList<Addressee> getaddresseeList() {
		return addresseeList;
	}

	public void setaddresseeList(ArrayList<Addressee> addresseeList) {
		this.addresseeList = addresseeList;
	}

}
