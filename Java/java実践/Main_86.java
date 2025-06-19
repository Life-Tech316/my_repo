//イテレータ

import java.util.*;

public class Main_86 {
    public static void main(String[] args){
      ArrayList<String> names = new ArrayList<String>();
      //配列の要素の追加
      names.add("しん");
      names.add("朝香");
      names.add("菅原");
      //イテレータの生成
      Iterator<String> it = names.iterator();
      //矢印が進めるのなら進める
      while(it.hasNext()){
        //矢印を次に次に進め取り出す
        String e = it.next();
        System.out.println(e);
      }
    }
}
