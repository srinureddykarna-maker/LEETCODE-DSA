class Solution {
    public boolean isHappy(int n) {
        int mod = 0;
        int sum = 0;
        while(n>4){
            while(n>0){
                mod = n%10;
                sum = sum+mod*mod;
                n=n/10;
            }
            n=sum;
            sum=0;
        }
        if(n==1)return true;
        else return false;
        
    }
}