public class Knapsack01{
	static int max(int a, int b) { return (a > b) ? a : b; }

	static int knapSack(int W, int wt[], int val[], int n)
	{
		if (n == 0 || W == 0)
			return 0;

		if (wt[n - 1] > W)
			return knapSack(W, wt, val, n - 1);
		else
			return max(val[n - 1] + knapSack(W - wt[n - 1], wt, val, n - 1),
					knapSack(W, wt, val, n - 1));
	}
	public static void main(String args[])
	{
		int val[] = new int[] { 1,2,3};
		int wt[] = new int[] {4,5,1};
		int W = 4;
		int n = val.length;
		System.out.println(knapSack(W, wt, val, n));
	}
}