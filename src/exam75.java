class Solution {
    public int solution(String[] babbling) {
        int count = 0;
        for(int i=0; i<babbling.length; i++){
            babbling[i] = babbling[i].replaceAll("aya", "A").replaceAll("ye","A").replaceAll("woo","A").replaceAll("ma","A");
            if(babbling[i].equals("A") || babbling[i].equals("AA") || babbling[i].equals("AAA") || babbling[i].equals("AAAA")) count++;
        }    
        return count;
    }
}
