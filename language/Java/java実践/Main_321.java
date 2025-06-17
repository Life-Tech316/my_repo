//Socketクラスが含まれる
import java.net.*;
//ファイル読み書き
import java.io.*;

public class Main_321{
  public static void main(String[] args) throws IOException{
    Socket sock = new Socket("172.20.10.2",39648);
    InputStream is = sock.getInputStream();
    OutputStream os = sock.getOutputStream();

    os.write("GET / HTTP/1.0¥r¥n".getBytes());
    os.write("¥r¥n".getBytes());

    InputStreamReader isr = new InputStreamReader(is);
    int i = isr.read();
    while(i != -1){
      System.out.print((char)i);
    }
    sock.close();
  }
}
