import java.awt.*;
import java.awt.event.*;

class MenuTest extends Frame implements ActionListener, ItemListener {
    public static void main(String[] args) {
        new MenuTest();
    }
    MenuTest() {
      setTitle("MenuTest");
      setSize(400, 220);
      setLayout(new FlowLayout());
      MenuBar menuBar = new MenuBar();
      setMenuBar(menuBar);


      //メニューオブジェクト作成
      Menu menuFile = new Menu("File");
      menuFile.addActionListener(this);
      menuBar.add(menuFile);

      //メニューアイテムオブジェクト追加
      MenuItem menuOpen = new MenuItem("Open...", new MenuShortcut('O'));
      menuFile.add(menuOpen);
      // [File]-[----]
      menuFile.addSeparator();
      // [File]-[Exit]
      MenuItem menuExit = new MenuItem("Exit");
      menuFile.add(menuExit);



      //メニューオブジェクト作成
      Menu menuView = new Menu("View");
      menuView.addActionListener(this);
      menuBar.add(menuView);
      // [View]-[Status Bar]
      CheckboxMenuItem menuStatusBar = new CheckboxMenuItem("Status Bar");
      menuStatusBar.addItemListener(this);
      menuView.add(menuStatusBar);

      Menu menuSize = new Menu("Size");
      menuSize.addActionListener(this);
      menuView.add(menuSize);
      // [View]-[Size]-[Large]
      MenuItem menuSizeLarge = new MenuItem("Large");
      menuSize.add(menuSizeLarge);
      // [View]-[Size]-[Small]
      MenuItem menuSizeSmall = new MenuItem("Small");
      menuSize.add(menuSizeSmall);

      Menu menuColor = new Menu("Color");
      menuColor.addActionListener(this);
      menuView.add(menuColor);
      MenuItem menuColorred = new MenuItem("red");
      menuColor.add(menuColorred);
      MenuItem menuColorblue = new MenuItem("blue");
      menuColor.add(menuColorblue);
      
      show();
  }
    @Override
    public void actionPerformed(ActionEvent e) {
    System.out.println(e.getActionCommand());
}
    @Override
    public void itemStateChanged(ItemEvent e) {
    CheckboxMenuItem menu = (CheckboxMenuItem)e.getSource();
    if (menu.getState()) {
        System.out.println(menu.getLabel() + " SELECTED");
    } else {
        System.out.println(menu.getLabel() + " DESELECTED");
    }
  }
}
