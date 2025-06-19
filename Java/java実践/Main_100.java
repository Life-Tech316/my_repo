import java.util.*;

public class Main_100{
  public static void main(String[] args){
    //Mapコレクション
    Map<String, Integer> prefs = new HashMap<String,Integer>();
    prefs.put("東京都",255);
    prefs.put("京都府",1261);
    prefs.put("熊本",255);
    int Tokyo = prefs.get("東京都");
    System.out.println("東京の人口は" + Tokyo);

    prefs.remove("京都府");
    prefs.put("熊本県",182);

    int Kumamoto = prefs.get("熊本県");

    System.out.println("熊本の人口は" + Kumamoto);
  }


}
