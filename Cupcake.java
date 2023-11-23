import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Gives our elephant type 2 diabetes.
 * 
 * @author (Justin Ye) 
 * @version (Nov 21, 2023)
 */
public class Cupcake extends Actor
{
    /**
     * Act - do whatever the Cupcake wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        setLocation(getX(),getY() + 1);
    }
}
