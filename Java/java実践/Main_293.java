import java.io.*;
import java.util.*;

public class Main_293{
  public static void main (String[] args) throws Exception {
    Writer fw = new FileWriter("Main_293.property");
    Properties p = new Properties();
    p.setProperty("Myouji","西塚");
    p.setProperty("Namae","拓馬");
    p.setProperty("Age","24");
    p.store(fw,"Charcter");
    fw.close();
  }
}
