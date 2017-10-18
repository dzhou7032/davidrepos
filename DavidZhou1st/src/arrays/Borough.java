package arrays;

public class Borough {
	public static final Borough[] NY_BOROUGHS = {new Borough("brooklyn"), new Borough ("bronx"), new Borough ("Manhattan"), new Borough ("Queens"), new Borough ("Staten Island")};
	private String name;
	
	public Borough(String name) {
		this.name = name;
	}
	public String toString() {
		return name;
	}
}
