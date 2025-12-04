import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SignTwo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SignTwo extends Actor
{
    /**
     * Act - do whatever the SignTwo wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private final FlashcardWorld worldRef;
    public SignTwo(FlashcardWorld worldRef){
        this.worldRef = worldRef;
        GreenfootImage img = new GreenfootImage(100,30);
        img.drawString("Accuracy", 2, 20);
        setImage(img);
    }
    
    public void act()
    {
        // Add your action code here.
    }
}
