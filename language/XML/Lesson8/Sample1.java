//クラスライブラリの使用
import java.io.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.stream.*;
import javax.xml.transform.dom.*;
import org.w3c.dom.*;

class Sample1{
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


    //文章を書き出す
    TransformerFactory tff
      = TransformerFactory.newInstance();
    Transformer tf
      = tff.newTransformer();
    tf.setOutputProperty(OutputKeys.ENCODING, "UTF8");
    tf.transform(new DOMSource(doc),
      new StreamResult("result.xml"));
  }
}
