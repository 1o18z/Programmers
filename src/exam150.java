import java.util.*;

class Solution {

  int[] discountPercent = {10, 20, 30, 40};
  ArrayList<int[]> ans;

  public int[] solution(int[][] users, int[] emoticons) {
    ans = new ArrayList<>();
    ans.add(new int[]{0, 0});

    dfs(users, emoticons, new int[emoticons.length], 0);
    ans.sort((o1, o2) -> o2[0] - o1[0] == 0 ? o2[1] - o1[1] : o2[0] - o1[0]);

    return ans.get(0);
  }

  public void dfs(int[][] users, int[] emoticons, int[] discounts, int index) {
    if (index == emoticons.length) {
      int buyEmoticonPlus = 0;
      int buyEmoticons = 0;

      for (int i = 0; i < users.length; i++) {
        int sum = 0;
        
        for (int j = 0; j < emoticons.length; j++) {
          if (discounts[j] >= users[i][0]) {
            sum += emoticons[j] / 100 * (100 - discounts[j]);
          }
        }
        
        if (sum >= users[i][1]) {
          buyEmoticonPlus++;
        } else {
          buyEmoticons += sum;
        }
      }
      
      ans.add(new int[]{buyEmoticonPlus, buyEmoticons});
    } else {
      for (int i = 0; i < 4; i++) {
        discounts[index] = discountPercent[i];
        dfs(users, emoticons, discounts, index + 1);
      }
    }
  }
}
