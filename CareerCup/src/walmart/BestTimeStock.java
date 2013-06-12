package walmart;

/*
 * http://stackoverflow.com/questions/9212299/buy-and-sell-stock-in-a-day
 * http://leetcode.com/2010/11/best-time-to-buy-and-sell-stock.html
 * http://fenghaolw.blogspot.fi/2012/11/trapping-rain-water.html
 * http://fenghaolw.blogspot.fi/2012/11/best-time-to-buy-and-sell-stock-iii.html
 * http://fenghaolw.blogspot.fi/2012/10/best-time-to-buy-and-sell-stock-ii.html
 */
public class BestTimeStock {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		 int[] a = new int[] { 4, 5, 3, 6, 1, 3 };
		//int[] a = new int[] { 1, 2, 2, 3, 5 };
		// int[] a = new int[] { 1, 4, 2, 4, 5 };
		maxProfit(a);
		maxProfit2(a);
		maxProfit3(a);
	}

	/*
	 * You may complete at most one transactions.
	 */
	public static void maxProfit(int prices[]) {

		int min = 0;
		int maxDiff = 0;
		int sell = 0;
		int buy = 0;
		for (int i = 0; i < prices.length; i++) {
			if (prices[i] < prices[min]) {
				min = i;
			} else {
				int diff = prices[i] - prices[min];
				if (diff > maxDiff) {
					buy = min;
					sell = i;
					maxDiff = diff;
				}
			}
		}

		System.out.println("buy: " + buy + ", sell: " + sell + ", dif: " + maxDiff);
	}

	/*
	 * You may complete at most two transactions.
	 */
	public static void maxProfit2(int[] prices) {

		if (prices == null || prices.length < 2)
			return;

		int minLR = prices[0];
		int maxRL = prices[prices.length - 1];
		int[] maxProfitLR = new int[prices.length]; // till that day - first
													// trans
		int[] maxProfitRL = new int[prices.length]; // after that day - second
													// trans
		int max = 0;

		for (int i = 1; i < prices.length; i++) {
			if (prices[i] < minLR) {
				minLR = prices[i];
			}
			maxProfitLR[i] = Math.max(maxProfitLR[i - 1], prices[i] - minLR);

		}

		for (int i = prices.length - 2; i > -1; i--) {
			if (prices[i] > maxRL) {
				maxRL = prices[i];
			}
			maxProfitRL[i] = Math.max(maxProfitRL[i + 1], maxRL - prices[i]);

		}

		for (int i = 0; i < prices.length; i++) {
			max = Math.max(max, maxProfitLR[i] + maxProfitRL[i]);
		}

		System.out.println(max);
	}

	/*
	 * You may complete as many transactions as you like.
	 */
	public static void maxProfit3(int[] prices) {

		if (prices.length == 0)
			return;
		int min = prices[0];
		int profit = 0;
		for (int i = 1; i < prices.length; i++) {
			if (prices[i] >= prices[i - 1]) {
				continue;
			}
			profit += prices[i - 1] - min;
			min = prices[i];
		}
		if (prices[prices.length - 1] > min) {
			profit += prices[prices.length - 1] - min;
		}
		
		System.out.println(profit);
	}

}
