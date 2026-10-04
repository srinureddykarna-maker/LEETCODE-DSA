class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character,Character> map1 = new HashMap<>();
        HashMap<Character,Character> map2 = new HashMap<>();


        for(int i=0;i<s.length();i++){
            char a = s.charAt(i);
            char z = t.charAt(i);
            if(map1.containsKey(a) && map1.get(a) != z){
                return false;
            }
            if(map2.containsKey(z) && map2.get(z) != a){
                return false;
            }
            map1.put(a,z);
            map2.put(z,a);

        }
        return true;
    }
}