class Solution {
    public int romanToInt(String s) {

        int res = 0;

        for(int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);
            int value = 0;

            if(ch == 'I') {
                value = 1;
            }
            else if(ch == 'V') {
                value = 5;
            }
            else if(ch == 'X') {
                value = 10;
            }
            else if(ch == 'L') {
                value = 50;
            }
            else if(ch == 'C') {
                value = 100;
            }
            else if(ch == 'D') {
                value = 500;
            }
            else if(ch == 'M') {
                value = 1000;
            }

            if(i + 1 < s.length()) {

                char next = s.charAt(i + 1);
                int nextValue = 0;

                if(next == 'I') {
                    nextValue = 1;
                }
                else if(next == 'V') {
                    nextValue = 5;
                }
                else if(next == 'X') {
                    nextValue = 10;
                }
                else if(next == 'L') {
                    nextValue = 50;
                }
                else if(next == 'C') {
                    nextValue = 100;
                }
                else if(next == 'D') {
                    nextValue = 500;
                }
                else if(next == 'M') {
                    nextValue = 1000;
                }

                if(value < nextValue) {
                    res -= value;
                }
                else {
                    res += value;
                }

            } else {
                res += value;
            }
        }

        return res;
    }
}