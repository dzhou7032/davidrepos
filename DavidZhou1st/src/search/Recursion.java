package search;

public class Recursion {

	 public static void main(String[] args){
		 int value = 10;
		 System.out.println(value+"! is equal to "+factorial(value));
		 System.out.println(value+ " has "+countPrimeFactors(value, 2)+" prime factors.");
		 }

		 public static int countPrimeFactors(int value, int testPrime) {
			 if (value<=0) {
			return 0;
			}
		if(value==testPrime) {
			 return 1;
		 }
			 if(value%testPrime==0) {
			 return 1+countPrimeFactors(value/testPrime,testPrime);
			 }
		 else {
			 return countPrimeFactors(value,testPrime+1);
		 }
		 	
		 }

		 public static long factorial(int value) {
			 if(value<0) {
				 return 0;
			 }
			 if(value>0) {
				 return value*factorial(value-1);
			 }
				 return 1;
		 }
}
