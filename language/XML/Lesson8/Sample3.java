//クラスライブラリの使用
import java.io.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.stream.*;
import javax.xml.transform.dom.*;
import org.w3c.dom.*;

class Sample3{
  public static void main(String args[]) throws Exception
  {
    //DOMの準備をする
    DocumentBuilderFactory dbf
      = DocumentBuilderFactory.newInstance();
    DocumentBuilder db
      = dbf.newDocumentBuilder();
    //文章を読み込む
    //parseメソッドの利用
    Document doc
      = db.parse(new FileInputStream("Sample.xml"));

    //ルート要素を得る
    Element root = doc.getDocumentElement();
    walk(root);
}

  public static void walk(Node n)
  {
      for(Node ch = n.getFirstChild();
          ch != null;
          ch = ch.getNextSibling()){
        System.out.println(ch.getNodeName());
    }
  }
}
