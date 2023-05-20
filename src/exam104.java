class Solution {
    public int solution(String skill, String[] skill_trees) {
        int result = 0;
        
        for(String s : skill_trees) {	
            StringBuilder sb = new StringBuilder();
            
            for(int i=0; i<s.length(); i++) {	
                if(skill.contains(s.charAt(i) + ""))
                    sb.append(s.charAt(i));
            }
            
            result += skill.indexOf(sb.toString()) == 0 ? 1 : 0;
        }
        return result;
    }
}
