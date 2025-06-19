import java.io.*;
import java.util.*;

public class Main_292{
  public static void main(String[] args) throws Exception{
    //ファイルを読み込む
    Reader fr = new FileReader("Main_293.property");
    Properties p = new Properties ();
    //ファイルの内容を読み込む
    p.load(fr);
    //キーを指定して読み込む
    String myouji = p.getProperty("Myouji");
    String namae = p.getProperty("Namae");
    String Age = p.getProperty("Age");
    int age = Integer.parseInt(Age);
    System.out.println("勇者の苗字" + myouji);
    System.out.println("勇者の名前" + namae);
    System.out.println("勇者の年齢" + age);
    fr.close();
  }
}
