import  java.io.*;

public class Main_303 {
  //Mainメソッドを投げる
  public static void main(String[] args) throws Exception{

  Main_Hero_302 hero1 = new Main_Hero_302("みなと",75,18);

  FileOutputStream fos =
              new FileOutputStream("rpgsave.dat");

  ObjectOutputStream oos = new ObjectOutputStream(fos);

  oos.writeObject(hero1);
  oos.flush();
  oos.close();

  FileInputStream fis =
              new FileInputStream("rpgsave.dat");
  ObjectInputStream ois = new ObjectInputStream(fis);
  Hero hero2 = (Hero) ois.readObject();
  ois.close();
  }
}
