package life;

public class Slime extends Monster{
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
