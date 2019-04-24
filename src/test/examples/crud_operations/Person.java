package test.examples.crud_operations;

public class Person {

	private long id;
	private String firstName;
	private String lastName;
	private String address;
	
	public Person() {
		
	}
	
	public Person(String firstName, String lastName, String address){
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
	}
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
}
