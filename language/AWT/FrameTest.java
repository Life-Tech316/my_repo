import java.awt.*;

public class FrameTest extends Frame {
    public static void main(String [] args) {
        new FrameTest();
    }
    //サブクラス
    FrameTest() {
        super("FrameTest");
        setSize(300, 200);
        setLayout(new FlowLayout());
        //ラベルクラス
        Label ll = new Label("HelloWorld");
        //ボタンクラス
        Button b1 = new Button("OK");
        //テキストフィールド
        TextField t1 = new TextField("Hello");
        //内容の設定
        TextArea b2 = new TextArea("Hello",3,20);
        t1.setText("違い");
        //チェックボックス
        Checkbox c1 = new Checkbox("OK");
        c1.setState(false);
        //チョイス項目追加
        Choice c2 = new Choice();
        c2.add("ChoiceA");
        c2.add("ChoiceB");
        c2.add("ChoiceC");
        List list1 = new List();
        list1.add("ListA");
        list1.add("ListB");
        //setLayout(new BorderLayout());
        Scrollbar sb1 = new Scrollbar(Scrollbar.HORIZONTAL);
        add(sb1, BorderLayout.SOUTH);
        add(list1);
        add(c2);
        add(b1);
        add(b2);
        add(ll);
        add(t1);
        show();
    }
}
