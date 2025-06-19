package life;

public class human {
  public void attack(Monster a){
    System.out.println("人間は"+a.name+"に攻撃された");
    a.run();

  }
}
