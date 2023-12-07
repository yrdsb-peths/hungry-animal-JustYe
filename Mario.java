import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The Elephant, our hero.
 * 
 * @author (Justin Ye) 
 * @version (Nov 21,2023)
 */
public class Mario extends Actor
{
    GreenfootSound marioCoin = new GreenfootSound("coin.mp3");
    GreenfootImage[] idleRight = new GreenfootImage[8];
    GreenfootImage[] idleLeft = new GreenfootImage[8];
    
    String facing = "right";
    SimpleTimer animationTimer = new SimpleTimer();

    int velocity;
    /**
     * Constructor - the code that gets run one time when an object is created.
     */
    public Mario()
    {
        for(int i = 0; i < idleRight.length; i++)
        {
            idleRight[i] = new GreenfootImage("images/mario/idle" + i + ".png");
            idleRight[i].scale(50,50);
        }
        
        for(int i = 0; i < idleLeft.length; i++)
        {
           idleLeft[i] = new GreenfootImage("images/mario/idle" + i + ".png");
           idleLeft[i].mirrorHorizontally();
           idleLeft[i].scale(50,50); 
        }
        
        animationTimer.mark();
        setImage(idleRight[0]);
    }
    
    /**
     * Animate mario
     */
    int imageIndex = 0;
    public void animateMario()
    {
        if(animationTimer.millisElapsed() < 180)
        {
            return;
        }
        animationTimer.mark();
        
        if(facing.equals("right"))
        {
            if(!Greenfoot.isKeyDown("d"))
            {
                setImage(idleRight[0]);
                return;
            }
            setImage(idleRight[imageIndex]);
            imageIndex = (imageIndex + 1) % idleRight.length;
        }
        else if(facing.equals("left"))
        {
            if(!Greenfoot.isKeyDown("a"))
            {
                setImage(idleRight[0]);
                return;
            }
            setImage(idleLeft[imageIndex]);
            imageIndex = (imageIndex + 1) % idleLeft.length;
        }
    }
    
    /**
     * Act - do whatever the Elephant wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        eat();
        animateMario();
        checkkeys();
    }
    
    public void checkkeys()
    {
        if(Greenfoot.isKeyDown("a"))
        {
            move(-6);
            facing = "left";
        }
        else if(Greenfoot.isKeyDown("d"))
        {
            move(6);
            facing = "right";
        }
        else
        {
            setImage(idleRight[0]);
        }
    }
    
    public void eat()
    {
        if(isTouching(Cupcake.class))
        {
            removeTouching(Cupcake.class);
            World1 world = (World1) getWorld();
            world.createCupcake();
            world.increaseScore();
            marioCoin.play();
        }
    }
}
