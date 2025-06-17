import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.io.*;

public class Main_297{
  public static void main(String[] args) throws Exception{
    //Inputメソッド
    InputStream is = new FileInputStream("xml.xml");
    Document doc = DocumentBuilderFactory.newInstance().
    newDocumentBuilder().parse(is);
    Element hero = doc.getDocumentElement();
    Element weapon = findChildByTag(hero,"weapon");
    Element power = findChildByTag(hero,"power");
    String value = power.getTextContent();
    System.out.println(value);
  }
  //エラーが発生した際は、Exceptionを投げる
  static Element findChildByTag(Element self, String name)
      throws Exception {
    //全ての子を習得する
    NodeList children = self.getChildNodes();
    //子の数分だけ繰り返す
    for(int i = 0; i < children.getLength();i++){
      if(children.item(i) instanceof Element ){
        Element e = (Element) children.item(i);
          if(e.getTagName().equals(name)){
            return e;
          }
        }
      }
      return null;
    }
}
