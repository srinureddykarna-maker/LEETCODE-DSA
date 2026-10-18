class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        if(pattern.length() != words.length) return false;
        HashMap<Character,Integer> map1 = new HashMap<>();
        HashMap<String,Integer> map2 = new HashMap<>();
        for(int i=0;i<pattern.length();i++){
            char c = pattern.charAt(i);
            String word = words[i];
            if(!map1.getOrDefault(c,0).equals(map2.getOrDefault(word,0))){
                return false;
            }
            map1.put(c,i+1);
            map2.put(word,i+1);

        }
        return true;
        
    }
}