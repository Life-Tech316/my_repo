import life.*;

public class Main13_10{
  public static void main(String[] args){
    Monster [] monsters = new Monster[3];
    human a = new human();
    monsters[0] = new Slime();
    monsters[1] = new Goblin();
    monsters[2] = new DeathBat();
    for (Monster m : monsters){
      //多態性の例
      m.run();
    }
    //monsters[0].attack();
    //明示的なキャストなキャストを行なって
    //子クラスでメソッドを定義直すやり方
    Slime slime = (Slime)monsters[0];
    slime.attack();
    //他の継承先のクラスでメソッドをオーバーライドして
    monsters[0].attack();
    a.attack(monsters[0]);
  }
}
