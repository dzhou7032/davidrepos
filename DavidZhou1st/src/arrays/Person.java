package arrays;
public class Person {
	
	public static final String[] FIRST_START = {"Chr", "M", "L", "Gr", "Ph", "B", "Th"};
	public static final String[] FIRST_MIDDLE = {"istie", "icha", "era","eta", "ala", "ina", "ara"};
	public static final String[] FIRST_END = {"", "na", "n", "r", "tian", "s", "rs", "mp", "les"}; 
	
	public static final String[] LAST_START = {"Tr", "Br", "L", "Gr", "Sh", "B", "Th"};
	public static final String[] LAST_MIDDLE = {"om", "o", "era","eta", "ala", "ina", "ara"};
	public static final String[] LAST_END = {"", "na", "ers", "rian", "ston", "ck", "rs", "sk", "les"}; 
	
	private String firstName;
	private String lastName;
	private Borough home;
	private Hobby hobby;
	private Person[] friends;
	public Person(String first, String last, Borough home) {
		this.firstName= first;
		this.lastName = last;
		this.home = home;
		this.hobby = Hobby.randomHobby();
		friends = new Person[3];
		
	}
	public void mingle(Person[] people) {
		for(Person p: people) {
			if(p!=this){
				p=betterFriend(p,friends[0]);
				addFriendToFirstPlace(p);
			}
		}
	}
	private Person betterFriend(Person p, Person person) {
		if (p == null) {
			return person;
		}
		if (person==null) {
			return p;
		}
		if (p.getClass()==this.getClass()) {
			return p;
		}
		if (person.getClass()==this.getClass()) {
			return person;
		}
		//if none these are true, just take p
		return p;
	}
	public void printFriends() {
		System.out.println("My name is "+firstName+lastName+" and these are my friends:");
		for (Person f: friends) {
			if (f != null) System.out.println(f);
			}
		}
	public void addFriendToFirstPlace(Person p) {
		for(int i =friends.length-1; i>0;i--) {
			friends[i]=friends[i-1];
		}
		friends[0]=p;
	}
	public String toString() {
		return "My name is "+firstName+" "+lastName+" and I live in "+home+".";
	}
}

