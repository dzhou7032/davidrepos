package towerOfHanoi;

public class TowerOfHanoi {
	public static void main(String[] args) {
		hanoi(4, "A", "B", "C");
	}
	public static void hanoi(int n, String start, String helper, String end){
		if(n==1) {
			System.out.println(start+" to "+end);
		}
		else {
			hanoi(n-1, start, end, helper);
			System.out.println(start+" to "+end);
			hanoi(n-1, helper, start, end);
		}
	}
}
