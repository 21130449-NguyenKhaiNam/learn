package LeetCode;

public class BestTimetoBuyandSellStock {
	/*
	 * Cho mang gia co phieu, tinh loi nhuan cao nhat neu mua va ban trong tam mang,
	 * neu khong thu duoc loi nhuan thi tra ve 0
	 */
	// So lan sai: 7
	public int maxProfit(int[] prices) {
//		Cach khac
//	    int min = Integer.MAX_VALUE;
//        int maxprofit = 0;
//        for(int i = 0; i<prices.length; i++){
//            if(prices[i]<min){
//                min = prices[i];
//            }
//
//            maxprofit = Math.max(maxprofit, prices[i] - min);
//            
//        }
//        return maxprofit;
		int max = 0;
		for (int i = 0; i < prices.length - 1; i++) {
			for (int j = i + 1; j < prices.length; ++j) {
				max = Math.max(max, prices[j] - prices[i]);
			}
		}
		return max;
	}
}
