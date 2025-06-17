import java.util.*;

public class Main_289{
  public static void main(String[] args){
    String s = "拓馬,奈々,明子,弘一";
    StringTokenizer st = new StringTokenizer(s,",");
    while (st.hasMoreTokens()){
      String t = st.nextToken();
      System.out.println(t);
      }
  }
}
