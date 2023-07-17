import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) throws Exception{

        Map<String, String> parkingMap = new HashMap<>();
        Map<String, Integer> feeMap = new TreeMap<>();

        for (int i = 0; i < records.length; i++) {
            String[] record = records[i].split(" "); 

            if (record[2].equals("IN")) {
                parkingMap.put(record[1], record[0]);
            } else {
                parse(parkingMap.get(record[1]), record[0], record[1], feeMap);
                parkingMap.remove(record[1]); 
            }
        }
          
        if (!parkingMap.isEmpty()) {
            for (String s : parkingMap.keySet()) {
                parse(parkingMap.get(s), "23:59", s, feeMap);
            }
        }
      
        calculateFee(fees, feeMap);
        return printAllFees(feeMap);
    }

    public static void parse(String inTime, String outTime, String carNumber, Map<String, Integer> feeMap) throws Exception{
        String[] out = outTime.split(":");
        int afterTime = Integer.parseInt(out[0]) * 60 + Integer.parseInt(out[1]);
      
        String[] in = inTime.split(":");
        int beforeTime = Integer.parseInt(in[0]) * 60 + Integer.parseInt(in[1]);
      
        int result = afterTime - beforeTime;
        feeMap.put(carNumber, feeMap.getOrDefault(carNumber, 0) + result);
    }

    public static void calculateFee(int[] fees, Map<String, Integer> feeMap) {
      
        for(String key: feeMap.keySet()){
            if(feeMap.get(key) < fees[0]){
                feeMap.put(key, fees[1]);
            } else{
                double time = (feeMap.get(key) - fees[0]);
                time = Math.ceil(time / fees[2]);
                int resultFee = (int)(time * fees[3] + fees[1]);
                feeMap.put(key, resultFee);
            }
        }
    }

    public static int[] printAllFees(Map<String, Integer> feeMap) {
        List<Integer> feeList = new ArrayList<>();

        for(String key : feeMap.keySet()){
            feeList.add(feeMap.get(key));
        }
        int[] result = new int[feeList.size()];
        for(int i=0; i<feeList.size(); i++){
            result[i] = feeList.get(i);
        }
        return result;
    }
    
}
