class Solution {
    static int[] intersection(int[] arr1, int[] arr2) {
        HashSet<Integer> set = new HashSet<>();

        for (int num : arr1) {
            set.add(num);
        }

        HashSet<Integer> ans = new HashSet<>();

        for (int num : arr2) {
            if (set.contains(num)) {
                ans.add(num);
            }
        }

        int[] result = new int[ans.size()];
        int i = 0;

        for (int num : ans) {
            result[i++] = num;
        }

        return result;
    }
}