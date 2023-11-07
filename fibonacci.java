import java.util.*;
public class fibonacci {
	
	

	static int icount=0,rcount=0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long istart = System.nanoTime();
		ifibocount(n);
		long iend = System.nanoTime();
		System.out.println();
		long rstart = System.nanoTime();
		for(int i=0;i<n;i++) {
			System.out.print(rfibo(i) + " ");
		}
		long rend = System.nanoTime();
		System.out.println("ifibo count = " + icount + "\nTime required: " + (iend-istart));
		System.out.println("rfibo count = " + rcount + "\nTime required: " + (rend-rstart));
	}
	static int ifibocount(int n) {
		int n1=0;
		int n2=1;
		int next=0;
		if(n<=1) {
			return n;
		}
		for(int i=0;i<n;i++) {
			System.out.print(n1 + " ");
			icount++;
			next = n1+n2;
			n1=n2;
			n2=next;
		}
		return 0;
	} 
	
	static int rfibo(int n) {
		if (n<=1){
			return n;
		}
		rcount++;
		return rfibo(n-1)+rfibo(n-2);
	}
}


//public static void main(String[] args) {
//	Scanner scanner = new Scanner(System.in);
//	System.out.print("Enter the number of Fibonacci numbers to calculate:");
//	int n = scanner.nextInt();
//
//	long[] fibonacciSeries = new long[n];
//	long stepCount = 0;
//
//	if (n >= 1) {
//		fibonacciSeries[0] = 0;
//		stepCount++;
//	}
//	if (n >= 2) {
//		fibonacciSeries[1] = 1;
//		stepCount++;
//	}
//
//	for (int i = 2; i<n; i++) {
//		fibonacciSeries[i] = fibonacciSeries[i - 1] + fibonacciSeries[i - 2];
//		stepCount += 3; // Each iteration includes 3 steps: addition, access previous two values, and assignment.
//	}
//
//	System.out.println("Fibonacci Series:");
//	for (int i = 0; i<n; i++) {
//		System.out.print(fibonacciSeries[i] + " ");
//	}
//
//	System.out.println("\nTotal steps taken to calculate the Fibonacci series: " + stepCount);
//}
