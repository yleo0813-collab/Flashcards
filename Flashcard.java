import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Flashcard here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Flashcard extends Actor
{
    private String question;
    private String answer;
    private GreenfootImage backImage;
    private GreenfootImage frontImage;
    private boolean isFaceUp;
    /**
     * Act - do whatever the Flashcard wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    
    
    public void flip(){
        if(isFaceUp){
            setImage(backImage);
        }
        else{
            setImage(frontImage);
        }
    }
    public Flashcard(String question, String answer, GreenfootImage back){
        this.question = question;
        this.answer = answer;
        this.backImage = back;
        this.frontImage = new GreenfootImage(question, 24, Color.BLACK, Color.WHITE);
        setImage(backImage);
        isFaceUp = false;
    }
    public void act(){
        if(Greenfoot.mouseClicked(this)){
            flip();
        }
    }
}
