import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class titleScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class titleScreen extends World
{
    Label titleLabel = new Label("Mario's Cardio Workout",50);

    /**
     * Constructor for objects of class titleScreen.
     * 
     */
    public titleScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 

        addObject(titleLabel, getWidth()/2, getHeight()/2);
        prepare();
    }

    /**
     * the main world loop.
     */
    public void act()
    {
        if(Greenfoot.isKeyDown("s"))
        {
            World1 gameWorld = new World1();
            Greenfoot.setWorld(gameWorld);
        }
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Mario mario = new Mario();
        addObject(mario,299,98);
        Label label = new Label("Press 'a' and 'd' to move", 40);
        addObject(label,295,265);
        Label label2 = new Label("Press 's' to Start", 30);
        addObject(label2,299,328);
        Label label3 = new Label("PS: it's cardio so stop pressing <space> ", 25);
        addObject(label3,282,26);
        label3.setLocation(330,34);
    }
}
