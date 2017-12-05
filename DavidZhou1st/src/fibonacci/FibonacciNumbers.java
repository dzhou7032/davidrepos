package fibonacci;

public class FibonacciNumbers {

	public static void main(String[] args) {
		FibonacciRun(2, 10);

	}

	private static void FibonacciRun(int x, int y) {
		if(y<=0) {
			System.out.println(x);
		}
		if (x<2) {
			FibonacciRun(x+1,y-1);
		}else {
			System.out.println("df");
			FibonacciRun(x+x,y-1);
		}
	}

}
