class Solution {
    static int result=0;
    static boolean[] visited;
    
    public int solution(String begin, String target, String[] words) {
        visited = new boolean[words.length];
        dfs(begin, target, words, 0);
        return result;
    }
  
    static void dfs(String begin, String target, String[] words, int count){
        if(begin.equals(target)){
            result = count;  
            return;
        }
        
        for(int i=0; i<words.length; i++){
            if(visited[i]) continue;
            
            int s = 0;
            for(int j=0; j<begin.length(); j++){
                if(begin.charAt(j) == words[i].charAt(j)) {
                    s++;
                }
            }
            if(s == begin.length() - 1){
                visited[i] = true;
                dfs(words[i], target, words, count+1);
                visited[i] = false;
            }
        }
    }
}
