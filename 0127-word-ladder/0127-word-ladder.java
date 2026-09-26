class pair{
    String word;
    int weight;
    pair(String word,int weight){
        this.word = word;
        this.weight = weight;
    }
}
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<pair>q = new LinkedList<>();
        q.add(new pair(beginWord,1));
        Set<String> s = new HashSet<>();
        int l = wordList.size();
        for(int i=0;i<l;i++){
            s.add(wordList.get(i));
        }
        s.remove(beginWord);
        while(!q.isEmpty()){
            String word =q.peek().word;
            int dist =q.peek().weight;
            q.remove();
            if(word.equals(endWord)==true) return dist;
            for(int i=0;i<word.length();i++){
                for(char ch='a';ch<='z';ch++){
                    char replacedcharArray[] = word.toCharArray();
                    replacedcharArray[i] = ch;
                    String replaceWord  = new String(replacedcharArray);
                    if (s.contains(replaceWord) == true){
                        s.remove(replaceWord);
                        q.add(new pair(replaceWord,dist+1));
                    }
                }
            }
        }
        return 0;
    }
}