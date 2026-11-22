public class Contact {
    private String name;
    private String phoneNumber;
    private String email;
    private String department;
    private String roomNumber;

    public Contact(String name, String phoneNumber, String email, String department, String roomNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.department = department;
        this.roomNumber = roomNumber;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getDepartment() {
        return department;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
	
	public void setEmail(String email) {
        this.email = email;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String toString() {
    return "Name: " + name +
           "\nPhone: " + phoneNumber +
           "\nEmail: " + email +
           "\nDepartment: " + department +
           "\nRoom Number: " + roomNumber;
    }
}