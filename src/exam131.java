import java.util.*;
class Solution {
    public int solution(int[][] jobs) {
        int answer = 0; // 총 대기 시간
        int count = 0; // 처리된 작업 수 
        int jobsIndex = 0; // 인덱스
        int time = 0; // 현재 시간
        
        Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]); // 요청 시간에 따라 오름차순 정렬
        
        PriorityQueue<int[]> que = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        // 소요 시간이 적은 순으로 처리

        while(count < jobs.length){ // 모든 작업이 처리될 때까지
            while(jobsIndex < jobs.length && jobs[jobsIndex][0] <= time){ // 인덱스가 길이보다 작고 
                que.add(jobs[jobsIndex++]); // 현재 시간 이전에 요청된 작업 다 추가
            }
            
            if(!que.isEmpty()){
                int[] current = que.poll();
                time += current[1];
                answer += time - current[0];
                count++;
            } else{
                time = jobs[jobsIndex][0];
            }
        }
        return answer/count;
    }
}
