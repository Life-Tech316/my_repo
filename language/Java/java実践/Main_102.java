import java.util.*;

public class Main_102{
  public static void main(String[] args){
    //Mapコレクション
    Map<String, Integer> prefs = new HashMap<String,Integer>();
    prefs.put("東京都",255);
    prefs.put("京都府",1261);
    prefs.put("熊本",255);
    prefs.put("群馬",255);
    prefs.put("埼玉",255);
    //キーの一覧を習得
    for (String key : prefs.keySet()){
      int value = prefs.get(key);
      System.out.println(key + "の人口は" + value);
    }
  }
}
