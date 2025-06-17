import java.util.*;

class Hero {
  public String name;
}

public class Main_104{
  public static void main(String[] args){
    //Heroインスタンス生成
    Hero h = new Hero();
    h.name = "みなと";
    //Listの箱に,ArrayListの中身を入れる
    List<Hero> list = new ArrayList<Hero>();
    list.add(h);
    h.name = "菅原";
    System.out.println(list.get(0).name);
    }
}
