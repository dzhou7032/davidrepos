package twoDArrays;

public class Main {

	public static void main(String[] args) {
		int[] df = {4,5,6};
		int[] fd = {5,7,8};
		int[] xz = {7,8,9};
		
		changeNeighbors(df,2);
		System.out.println(df);
	}
	public static void changeNeighbors(int[] arr, int psn) {
			if (psn<arr.length-1&&psn!=0) {
				arr[psn]++;
				arr[psn-1]--;
				arr[psn+1]--;
			}
			if (psn==0) {
				arr[psn]++;
				if (arr.length>1) {
					arr[psn+1]--;
				}
			}
			else {
				arr[psn]++;
				arr[psn-1]--;
			}
	}
}
