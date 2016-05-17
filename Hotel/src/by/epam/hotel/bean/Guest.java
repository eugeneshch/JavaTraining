package by.epam.hotel.bean;

public class Guest {
	private String fName;
	private String lName;
	private String phone;
	
	public Guest() {
	}
		
	public Guest(String fName, String lName, String phone) {
		this.fName = fName;
		this.lName = lName;
		this.phone = phone;
	}
	
	public String getFName() {
		return fName;
	}
	public void setFName(String fName) {
		this.fName = fName;
	}
	public String getLName() {
		return lName;
	}
	public void setLName(String lName) {
		this.lName = lName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
}
