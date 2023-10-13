package bitlabs123.patientJDBC;

public class Patient {
	private int id;
	private String name;
	private String gender;
	private int age;
	private long mobile;
	private String address;
	private String date_of_joining;
	public Patient(int id,
	 String name,
	 String gender,
	 int age,
	 long mobile,
	 String address,
	 String date_of_joining) {
		this.id=id;
		this.name=name;
		this.gender=gender;
		this.age=age;
		this.mobile=mobile;
		this.address=address;
		this.date_of_joining=date_of_joining;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public long getMobile() {
		return mobile;
	}
	public void setMobile(long mobile) {
		this.mobile = mobile;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDate_of_joining() {
		return date_of_joining;
	}
	public void setDate_of_joining(String date_of_joining) {
		this.date_of_joining = date_of_joining;
	}
	
	@Override
	public String toString() {
		return "Patient [id=" + id + ", name=" + name + ", gender=" + gender + ", age=" + age + ", mobile=" + mobile
				+ ", address=" + address + ", date_of_joining=" + date_of_joining + "]";
	}
	
}
