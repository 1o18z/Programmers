import java.util.*;

public class exam81 {

  public String solution(String new_id) {
      String result1 = Generator1(new_id);
      String result2 = Generator2(result1);
      String result3 = Generator3(result2);
      String result4 = Generator4(result3);
      String result5 = Generator5(result4);
      String result6 = Generator6(result5);
      String result7 = Generator7(result6);
      return result7;
  }

  public String Generator1 (String new_id){
    new_id = new_id.toLowerCase();
    return new_id;
  }

  public String Generator2 (String new_id){
    new_id = new_id.replaceAll("[^a-z0-9[.]-_]", "");
    return new_id;
  }

  public String Generator3 (String new_id){
    new_id = new_id.replaceAll("[.]{2,}", ".");
    return new_id;
  }

  public String Generator4 (String new_id){
    if(new_id.startsWith(".")){
      new_id = new_id.replaceFirst(".", "");
    }
    if(new_id.endsWith(".")){
      new_id = new_id.substring(0, new_id.length()-1);
    }
    return new_id;
  }

  public String Generator5 (String new_id){
    if(new_id.isEmpty()){
      new_id = "a";
    }
    return new_id;
  }

  public String Generator6 (String new_id){
    if(new_id.length() > 15){
      new_id = new_id.substring(0, 15);

      if(new_id.endsWith(".")){
        new_id = new_id.substring(0, new_id.length()-1);
      }
    }

    return new_id;
  }

  public String Generator7 (String new_id){
    if(new_id.length() <= 2){
      char endstr = new_id.charAt(new_id.length()-1);

      while(new_id.length() < 3){
        new_id += endstr;
      }
    }
    return new_id;
  }


  public static void main(String[] args) {

//    String new_id = "...!@BaT#*..y.abcdefghijklm";
//    String new_id = "abcdefghijklmn.p";
    String new_id = "=.=";
    exam1018 exam = new exam1018();

    System.out.println(exam.solution(new_id));
  }
}
