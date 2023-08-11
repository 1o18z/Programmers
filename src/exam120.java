import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Collections;
import java.util.StringTokenizer;

class Solution {
    public Long solution(String expression) {
        List<String> expressionList = new LinkedList<>();
        List<Long> resultList = new ArrayList<>();
        
        StringTokenizer st = new StringTokenizer(expression, "+-*", true);
        while (st.hasMoreTokens()) {
            expressionList.add(st.nextToken());
        }

        String[][] operators = {{"*","+","-"}, 
                                {"*","-","+"}, 
                                {"-","*","+"},
                                {"-","+","*"},
                                {"+","*","-"},
                                {"+","-","*"}};
        
        for(int i=0; i<operators.length; i++){
            List<String> midList = new LinkedList<>(expressionList);
                for(int j=0; j<3; j++){
                    for(int k=0; k<midList.size(); k++){
                        if(midList.get(k).equals(operators[i][j])){
                            String midResult = calculate(midList.get(k-1), midList.get(k), midList.get(k+1));
                            midList.set(k-1, midResult);
                            midList.remove(k);
                            midList.remove(k);
                            k--;
                        }
                    }
                }
            long result = Long.parseLong(midList.get(0));
            resultList.add(Math.abs(result));
        }
        return Collections.max(resultList);
    }
    
    static String calculate(String number1, String operator, String number2){
        long calculatedValue = 0;
        long num1 = Long.parseLong(number1);
        long num2 = Long.parseLong(number2);
        
        if(operator.equals("+")) calculatedValue += (num1 + num2); 
        if(operator.equals("-")) calculatedValue += (num1 - num2);
        if(operator.equals("*")) calculatedValue += (num1 * num2);
        
        return String.valueOf(calculatedValue);
    }
}
