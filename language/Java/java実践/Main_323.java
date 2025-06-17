import java.net.*;

public class Main_323{
  public static void main(String[] args) throws Exception{
      System.out.println("起動完了");
      ServerSocket svSock = new ServerSocket(39648);
      Socket sock = svSock.accept();
      System.out.println(sock.getInetAddress()+"からの接続");
      sock.getOutputStream().write("Welcom".getBytes());
      sock.getOutputStream().flush();
      sock.close();
  }
}
