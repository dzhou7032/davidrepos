package arrays;

import arrays.student;

public class ObjectArrays {

	public ObjectArrays() {
		Person[] people = new Person[100];
		Person[] people1 = new Person[100];
		populate(people);
		populate(people1);
		for(Person p: people) {
			p.mingle(people);
			p.printFriends();
			System.out.println("");
		}
		//System.out.print(Person.createNickname("Jonathan"));
	}
	public void populate(Object[] people) {
		for (int i =0; i<people.length;i++) {
			String firstName = randomNameFrom(Person.FIRST_START, Person.FIRST_MIDDLE, Person.FIRST_END);
			String lastName = randomNameFrom(Person.LAST_START, Person.LAST_MIDDLE, Person.LAST_END);
			Borough b = randomBorough();
			//BIG IDEA!!
			//In Object[] (but not primitive arrays like int[] or double[])
			//You can have multiple data types (sub-classes of the declared type)
			if (Math.random()<.6) {
			//60% of the time...	
				int grade = (int)(Math.random()*5)+9;
				people[i]= new student(firstName,lastName, b, grade);
			}
			else {
			//the other 40% of the time
			people[i] = new Person(firstName, lastName, b);
			}
		}
	}
	private Borough randomBorough() {
		return Borough.NY_BOROUGHS[(int)(Math.random()*Borough.NY_BOROUGHS.length)];  
	}
	private String randomNameFrom(String[]a,String[] b, String[] c) {
		return get(a)+get(b)+get(c);
	}
	private String get(String[] a) {
		return a[(int)(Math.random()*a.length)];
	}
	public Person[] selectGroup(Person[] population, int length) {
		Person[] container = new Person[length];
		for (int i=0;i<length;i++) {
			int ran = (int)Math.random()*population.length-1;
			for (int z=0;z<container.length;z++) {
				if (container[z]==population[ran]) {
					i=i-1;
				}
				else {
					container[i]=population[ran];
				}
			}
		}
		return container;
	}
	public double countDifferences(Person[] arr1, Person[] arr2) {
		int counter=0;
		for (int i=0;i<arr1.length;i++) {
			if (arr1[i]!=arr2[i]) {
				counter++;
			}
		}
		return counter;
	}
}
