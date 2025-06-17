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

interface Creature{
  public int life = 0;
  public int name = 0;

  void run();
  void attack();
}

interface Dark{

  public int dark_level = 0;

  void run();
  void attack();
}



abstract class Monster implements Creature , Dark{
    public String name;
    abstract public void run();
    abstract public void attack();
}

class Slime extends Monster{
    public String name="スライム";


    public void run(){
      System.out.println("スライムは");
    }
    public void attack(){


      System.out.println("スライムはアタックした");
      System.out.println(this.dark_level);
      System.out.println(this.life);
    }
}

class Goblin extends Monster{
    String name="スライム";
    public void run(){
      System.out.println("ゴブリンは");
    }
    @Override
    public void attack(){
    }
}
class DeathBat extends Monster{
    String name="スライム";
    public void run(){
      System.out.println("地獄コウモリは");
    }
    @Override
    public void attack(){
    }

}

class human {
  public void attack(Monster a){
    System.out.println("人間は"+a.name+"に攻撃された");
    a.run();

  }

}
