package attendance;

public class Student implements Attendee {
	private String firstName;
	private String lastName;
	private boolean ifPresent;

	public Student(String first,String last) {
		this.firstName = first;
		this.lastName = last;
	}
	public boolean isPresent() {
		if (ifPresent == true) {
			return true;
		}
		return false;
	}

	public void setPresent(boolean present) {
		if (present == true) {
			ifPresent = true;
		}
		ifPresent = false;
	}

	
	public String getFirstName() {
		return firstName;
	}

	
	public String getLastName() {
		return lastName;
	}

	
	public boolean mathces(String first, String last) {
	if ((first.equalsIgnoreCase(firstName))&&(last.equalsIgnoreCase(lastName))) {
		return true;
	}
	return false;
	}

	public boolean matches(String last) {
		if (last.equalsIgnoreCase(lastName)) {
			return true;
		}
		return false;
	}

	
	public String getReportString() {
		String tempLastName = null;
		String tempFirstName = null;
		String finale;
		if (lastName.length() > 20) {
			tempLastName = lastName.substring(0, 17) + "...";
		}
		if (lastName.length() <= 20) {
			tempLastName = lastName;
		}
		if (firstName.length()>20) {
			tempFirstName = firstName.substring(0, 17)+"...";
		}
		if (firstName.length() <= 20) {
			tempFirstName = firstName;
		}
		finale = tempLastName;
		for (int i = 0; i < (20 - tempLastName.length()); i++){
			finale = finale + " ";
		}
		finale = finale + tempFirstName;
		for (int i = 0; i < (20-tempFirstName.length()); i++) {
			finale = finale + " ";
		}
		if (ifPresent == true) {
			finale = finale + "PRESENT";
			return finale;
		}
		else{
			finale = finale + "ABSENT";
			return finale;
		}
	}

}
