class Solution {
    public String reverseVowels(String s) {
        int left=0;
        int right = s.length()-1;
        HashSet<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        char[] arr = s.toCharArray();


        while(left<=right){
            while(left<right && !set.contains(Character.toLowerCase(arr[left]))){
                left++;
            }
            while(left<right && !set.contains(Character.toLowerCase(arr[right]))){
                right--;
            }
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
                return new String(arr);

    }
}