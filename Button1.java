import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Button1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Button1 extends Actor
{
    /**
     * Act - do whatever the Button1 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     * 
     * 
     */
    
    private final FlashcardWorld worldRef;
    
    public Button1(FlashcardWorld worldRef){
        this.worldRef = worldRef;
        GreenfootImage img = new GreenfootImage(100,30); 
        img.drawString("Hard", 2, 20);
        setImage(img);
    }
    public void act(){
        if(Greenfoot.mouseClicked(this)){
            Flashcard x = worldRef.getCurrentCard();
            x.setWrong();
            //worldRef.updateProgress();
            worldRef.showNextCard();
        }
        
        
    
    }
    
}
