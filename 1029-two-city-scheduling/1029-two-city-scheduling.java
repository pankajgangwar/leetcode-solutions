class Solution {
    public int twoCitySchedCost(int[][] costs) {
      int n = costs.length;
		int totalCost = 0;
		
		Arrays.sort(costs, new Comparator<int[]>() {
			@Override
			public int compare(int[] a, int[] b) {
                int diffa = a[0] - a[1];
                int diffb = b[0] - b[1];
                return Integer.compare(diffa, diffb);
			}
		});
        
		for (int i = 0; i < n/2; i++) {
			totalCost+= costs[i][0];
		}
		
		for (int i = n/2; i < n; i++) {
			totalCost+= costs[i][1];
		}

		return totalCost;
	  
    }
}