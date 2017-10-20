package arrays;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		//ObjectArrays oA= new ObjectArrays();
		Person s = new Person("Ben", "Nockles", Borough.NY_BOROUGHS[0]);
		int x=10;
		int[] a= {5,6,7};
		test(s,x,a);
		System.out.println(s+", "+x+", "+Arrays.toString(a));
	}
	/** NO METHOD CAN PERMANENTLY CHANCE AN INT(YOU CAN IF YOU SET IT AS A RETURN TYPE)
	 */
	public static void test(Person s, int x, int[] arr) {
		s.setFirstName("Ilona");
		x=5;
		//arr=new int[3]; AS LONG AS YOU DON'T MAKE A 'NEW' ARRAY
		//THE REFERENCES THEMSELVES WILL CHANGE
		arr[0]=1;
		arr[1]=2;
		arr[2]=3;
	}

}
