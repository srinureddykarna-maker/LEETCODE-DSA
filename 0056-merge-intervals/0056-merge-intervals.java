class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals,(a,b)  -> Integer.compare(a[0],b[0]));
        List<int[]> ans = new ArrayList<>();
        for(int i=0;i<n;i++){
            int start = intervals[i][0];
            int end = intervals[i][1];
            if(ans.isEmpty() || start > ans.get(ans.size()-1)[1]){
                ans.add(new int[]{start,end});

            }else{
                int[] lastinterval = ans.get(ans.size()-1);
                lastinterval[1] = Math.max(lastinterval[1],end);
            }
        }

        return ans.toArray(new int[ans.size()][]);
    }
}