import java.util.HashMap;
import java.util.Map;
import java.util.HashSet;
import java.util.Set;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

class Solution {
    static Map<String, Integer> map = new HashMap<>();
    static Set<String> reports = new HashSet<>(); // 중복 신고 제거
    static Set<String> blackList = new HashSet<>(); // 정지당한 리스트
    
    public int[] solution(String[] id_list, String[] report, int k) {
        removeDuplicateReport(report);
        updateBlackList(k);
        
        return countMail(id_list);
    }
    
    void removeDuplicateReport(String[] report){
        Collections.addAll(reports, report);
    }
    
    void updateBlackList(int k){
        for(String value : reports){
            String reportee = value.split(" ")[1];
            map.put(reportee, map.getOrDefault(reportee, 0) +1); // 신고 당한 횟수 저장
            
            if(map.get(reportee) >= k) blackList.add(reportee); // k번 이상이면 블랙리스트 등록
        }
    }

    int[] countMail(String[] id_list){
        int[] result = new int[id_list.length];
        List<ReportInfo> list = new ArrayList<>();
      
        for(String value : reports){
            String[] name = value.split(" ");
            list.add(new ReportInfo(name[0], name[1]));
        }
        
        for(int i=0; i<id_list.length; i++){
            int count = 0;
          
            for(ReportInfo report : list){    
                if(report.reporter.equals(id_list[i]) && blackList.contains(report.reportee)) count++;
            }
            result[i] = count;
        }
        return result;
    }
}

class ReportInfo { // split()은 비용이 비싸므로 호출을 최소화하기 위해 해당 클래스 생성
    String reporter;
    String reportee;
    
    ReportInfo(String reporter, String reportee){
        this.reporter = reporter;
        this.reportee = reportee;
    }
}
