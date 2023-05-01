class Solution
{
    public int solution(int n, int a, int b)
    {
        int count = 0;
        
        while(true){
            a = a/2+a%2;
            b = b/2+b%2;
            count++;
            if(b==a) break;
        }
        return count;
    }
}
