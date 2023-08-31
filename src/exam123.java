import java.util.Set;
import java.util.HashSet;

class Solution {
    class Position{
        double x;
        double y;
        
        public Position(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    
    public int solution(String dirs) {
        int answer = 0;
        Set<String> set = new HashSet<>();
        Position position = new Position(0,0);    
        
        for(char i : dirs.toCharArray()){
            if(i == 'U' && position.y < 5){
                position.y++;
                String moving = position.x + "," + (position.y - 0.5);
                set.add(moving);
            }
            else if(i == 'R' && position.x < 5){
                position.x++;
                String moving = (position.x - 0.5) + "," + position.y;
                set.add(moving);
            }
            else if(i == 'D' && position.y > -5){
                position.y--;
                String moving = position.x + "," + (position.y + 0.5);
                set.add(moving);
            }
            if(i == 'L' && position.x > -5){
                position.x--;
                String moving = (position.x + 0.5) + "," + position.y;
                set.add(moving);
            }
        }
        answer = set.size();
        return answer;
    }
}
