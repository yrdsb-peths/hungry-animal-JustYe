import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The world the elephant lives in.
 * 
 * @author (Justin) 
 * @version (Nov 21 2023)
 */
public class MyWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        
        Elephant john = new Elephant();
        addObject(john, 300, 200);
        
        createCupcake();
    }
    
    public void createCupcake()
    {
        Cupcake a = new Cupcake();
        int x = Greenfoot.getRandomNumber(600);
        int y = 0;
        addObject(a,x,y);
    }
}
