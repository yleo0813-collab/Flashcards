import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Button2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Button2 extends Actor
{
    /**
     * Act - do whatever the Button2 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Button2(){
        GreenfootImage img = new GreenfootImage(100,30);
        img.drawString("Hard", 2, 20);
        setImage(img);
    }
    public void act()
    {
        // Add your action code here.
    }
}
