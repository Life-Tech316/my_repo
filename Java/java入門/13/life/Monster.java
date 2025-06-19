package life;

public abstract class Monster implements Creature , Dark{
    public String name;
    abstract public void run();
    abstract public void attack();
}
