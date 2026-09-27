class Solution {
    Map<String,Integer>map;
    String b ;
    List<List<String>>ans;
    public void dfs(String word,List<String> seq){
        if(word.equals(b)){
            List<String> dup = new ArrayList<>(seq);
            Collections.reverse(dup);
            ans.add(dup);
            return;
        }
        int steps = map.get(word);
        int sz = word.length();
        for(int i=0;i<sz;i++){
            for(char ch = 'a';ch<='z';ch++){
                char replacedcharArray[] = word.toCharArray();
                    replacedcharArray[i] = ch;
                    String replacedword = new String(replacedcharArray);
                    if(map.containsKey(replacedword) && map.get(replacedword)+1 == steps){
                        seq.add(replacedword);
                        dfs(replacedword,seq);
                        seq.remove(seq.size()-1);
        
                    }
            }
        }
    }
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        int n = wordList.size();
        Set<String> s = new HashSet<>();
        for(int i=0;i<n;i++){
            s.add(wordList.get(i));
        }
        map = new HashMap<>();
        b = beginWord;
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        map.put(beginWord,1);
        s.remove(beginWord);
        while(!q.isEmpty()){
            String word = q.peek();
            int steps = map.get(word);
            q.remove();
            if(word.equals(endWord)) break;
            for(int i=0;i<word.length();i++){
                for(char c = 'a';c<='z';c++){
                    char replacedcharArray[] = word.toCharArray();
                    replacedcharArray[i] = c;
                    String replacedword = new String(replacedcharArray);
                    if(s.contains(replacedword)==true){
                        q.add(replacedword);
                        s.remove(replacedword);
                        map.put(replacedword,steps+1);
                    }
                }
            }
        }
        ans = new ArrayList<>();
        if(map.containsKey(endWord)==true){
            List<String>seq = new ArrayList<>();
            seq.add(endWord);
            dfs(endWord,seq);
        }
        return ans;

        
    }
}