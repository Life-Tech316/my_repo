import java.awt.*;

class CanvasTest extends Frame{
  public static void main(String[] args){
    new CanvasTest();
  }
  CanvasTest(){
    super("CanvasTest");
    setSize(200, 100);
    setLayout(new BorderLayout());
    MyCanvas mc1 = new MyCanvas();
    add(mc1, BorderLayout.CENTER);
    show();
  }
}
