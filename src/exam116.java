import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.Stack;
import java.util.Arrays;

class Solution {
    public String[] solution(String[][] plans) {
      
        Map<Integer, Work> map = new HashMap<>();
        List<Work> workList = new ArrayList<>();

        for(int i=0; i<plans.length; i++){
            int startTime = toMinutes(plans[i][1]);
            Work work = new Work(plans[i][0], startTime, Integer.parseInt(plans[i][2]));
            map.put(startTime, work);
            workList.add(work);
        }
      
        workList.sort((a,b) -> a.startTime == b.startTime ? a.duringTime - b.duringTime : a.startTime - b.startTime);
        
        int start = workList.get(0).startTime;
        int count = 0;
        
        Stack<Work> stack = new Stack<>();
        List<String> resultList = new ArrayList<>();
      
        while(count < plans.length){
            if(!stack.isEmpty()){
                stack.peek().duringTime -= 1;
                if(stack.peek().duringTime == 0){
                    resultList.add(stack.peek().title);
                    stack.pop();
                    count++;
                }
            }
            if(map.containsKey(start)){
                stack.push(map.get(start));
            }
            start++;
      }
      
      return resultList.toArray(new String[resultList.size()]);
    }
    
    int toMinutes(String time){
        String[] splitTime = time.split(":");
        int hour = Integer.parseInt(splitTime[0]) * 60;
        int minute = Integer.parseInt(splitTime[1]);
        return (hour + minute);
    }    
    
    static class Work {
        private String title;
        private int startTime;
        private int duringTime;

        public Work(String title, int startTime, int duringTime) {
            this.title = title;
            this.startTime = startTime;
            this.duringTime = duringTime;
        }
      
    }
    
}
