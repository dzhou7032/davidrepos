package arrays;

import java.util.Arrays;

public class ArrayMain {
	private int[] testArray;
	private int[]intRay;
	
	
	public ArrayMain() {
		int[] TestArr1 = {1,2,3,6,7,8,9,10,11,45,46,47};
		intRay = new int[20];
		//populate(intRay);
		//checkOccurences(intRay,2,12);
		populate1ToN(intRay);
		//swap(intRay,0,1);
		//shuffle(intRay);
		reverseOrder(intRay);
		countLessThan(intRay, 5);
		//frontToBack(intRay);
		longestConsecutiveSequence(TestArr1);
		//Arrays is a Utility class included in Java for formatting output
		System.out.println(Arrays.toString(TestArr1));
	}
	private int countLessThan(int[] intRay2, int num) {
		int counter = 0;
		for (int i=0;i<intRay2.length;i++) {
			if (intRay2[i]<num) {
				counter++;
			}
		}
		return counter;
	}
	public void cycleThrough(int[] arr, int n) {
		for (int i = 0;i<n;i++) {
			frontToBack(arr);
		}
	}
	public void frontToBack(int[] arr) {
		int placeholder = arr[0];
		for (int i=0;i<arr.length-1;i++) {
			arr[i] = arr[i+1];
		}
		arr[arr.length-1]=placeholder;
	}
	private void reverseOrder(int[] intRay2) {
		int[] newArray = new int[intRay2.length];
		for (int i=0; i<intRay2.length;i++) {
			newArray[i]=intRay2[i];
		}
		for (int i=0; i<newArray.length/2; i++) {
			swap(newArray, i, newArray.length-1-i);
		}	
	}
	public int longestConsecutiveSequence(int[] arr) {
	int counter=0;
	int max=0;
	int posi = 1;
		for (int i=0;i<arr.length-1; i++) {
		if (arr[i]+1==arr[i+1]) {
			counter++;
		}
		else {
			if(counter>max) {
			max = counter;
			posi = i+1;
			counter = 0;
			}
			else {
				counter = 0;
			}
		}
	}
		if (counter>max) {
			max=counter;
		}
		System.out.print(max+1);
		System.out.print(posi);
		return max+1;
	}
	private void shuffle(int[] intRay2) {
		for (int i=0; i<intRay2.length;i++) {
			swap(intRay2,(int)(Math.random()*intRay2.length),(int)(Math.random()*intRay2.length));
		}
	}
	private void swap(int[] intRay2, int i, int j) {
		int placeholder = intRay2[i];
		intRay2[i]=intRay2[j];
		intRay2[j]=placeholder;
	}
	private void populate1ToN(int[] intRay) {
		for(int i=0;i<intRay.length; i++) {
			intRay[i] = i+1;
		}
	}
	private void checkOccurences(int[] arr, int start, int end) {
		int[] counter = new int[end-start+1];
		for (int value:arr) {
			counter[value-start]++;
		}
		for (int i=0;i<counter.length;i++) {
			System.out.println("A "+(start+i)+" was rolled "+counter[i]+" times.");
		}
	}
	private void populate(int[] intRay) {
		for(int i = 0;i<intRay.length;i++) {
			intRay[i]= diceRoll(2);
		}
	}
	public void notes() {
		//1.collection of primitives or objects
				//SPECIAL NOTE: This is the ONLY collection of primitives
				//2.size cannot be modified
				//3.Elements of an array are REFERENCES to objects.
				//in other words, changing an element of an array changes
				//the REFERENCE, not the object(more on this later)
				
				//There are two types of constructors, the first we've seen already:
				int[] firstType = {3,14,-9,10};
				//this constructor can only be used at the declaration. Error:
				//firstType = {12,13,14,15};
				
				//the 2nd type:
				testArray = new int[20];
				//SPECIAL NOTE: for primitive arrays, when they are instantiated,
				//they are automatically populated with 0s. This is not the case with Object arrays,
				//which are populated with 'null'
				
				//standard 'for' loop
				for(int i = 0;i<testArray.length;i++) {
					System.out.println(testArray[i]);
				}
				//for each loop(useful only when you don't need to keep track of an index
				for (int value:testArray) {
					//"for each int in testArray..."
					System.out.println(value);
				}
	}
	public static void main(String[] args) {
		ArrayMain arrayPractice = new ArrayMain();
	}
	
	public int diceRoll(int numberOfDice) {
	int roll = 0;
	for (int i = 0; i<numberOfDice; i++) {
		roll += 1+(int)(Math.random()*6);
	}
	return roll;
	}

}