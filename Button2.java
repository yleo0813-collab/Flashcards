import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Button2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Button2 extends Actor
{
    
    private final FlashcardWorld worldRef;
    /**
     * Act - do whatever the Button2 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Button2(FlashcardWorld worldRef){
        this.worldRef = worldRef;
        GreenfootImage img = new GreenfootImage(100,30);
        img.drawString("Easy", 2, 20);
        setImage(img);
    }
    public void act()
    {
        if(Greenfoot.mouseClicked(this)){
            Flashcard x = worldRef.getCurrentCard();
            x.setCorrect();
            //worldRef.updateProgress();
            worldRef.showNextCard();
        }
    }
}
