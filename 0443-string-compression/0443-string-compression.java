class Solution {
    public int compress(char[] chars) {
        int n = chars.length;
        int i=0;
        int write=0;
        while(i<n){
            char s = chars[i];
            int cnt =0;
            while(i<n && chars[i]==s){
                cnt++;
                i++;


            }
            chars[write] = s;
            write++;
            if(cnt > 1){
                String num = String.valueOf(cnt);
                for(int j=0;j<num.length();j++){
                    chars[write] = num.charAt(j);
                    write++;
                }
            }


        }
        return write;
    }
}