package bean;

public class User implements Bean {
	private int number;
	private String id;
	private String pass;
	private String name;
	private String address;
	private int age;
	private int point;
	private String phoneNumber;
	private int card_id;

	//-------------------------------------------------Number
	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}
	//-------------------------------------------------Id
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	//--------------------------------------------------Pass
	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}
	//--------------------------------------------------Name
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	//--------------------------------------------------Address
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	//--------------------------------------------------Age
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	//--------------------------------------------------Point
	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}
	//---------------------------------------------------PhoneNumber
	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	//-----------------------------------------------------Card_id

	public int getCard_id() {
		return card_id;
	}

	public void setCard_id(int card_id) {
		this.card_id = card_id;
	}
}
