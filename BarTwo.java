import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import greenfoot.Color;

/**
 * Write a description of class BarTwo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BarTwo extends Actor
{
    
    public int width;
    public int height;
    public int maxValue;
    private int currentValue;
    
    
    private FlashcardWorld worldRef;
    
    public BarTwo(int width, int height, int maxValue, FlashcardWorld worldRef){
        this.width = width;
        this.height = height;
        this.maxValue = maxValue;
        this.currentValue = 0;
        this.worldRef = worldRef;
        
        setImage(new GreenfootImage(width, height));
        draw();
    }
    /**
     * Act - do whatever the BarTwo wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public BarTwo(int width, int height, int maxValue){
        this.width = width;
        this.height = height;
        this.maxValue = maxValue;
        this.currentValue = 0;
        setImage(new GreenfootImage(width, height));
    }
    
    public void setValue(int value){
        currentValue = Math.max(0, Math.min(value, maxValue));
    }
    
    public void draw(){
        GreenfootImage img = new GreenfootImage(width, height);
        img.setColor(Color.WHITE);
        img.fill();
        
        img.setColor(Color.BLACK);
        img.drawRect(0, 0, width - 1, height - 1);
        double percent = ((double) currentValue)/maxValue;
        int filledAmount = (int)(percent * (width - 2));
        
        img.setColor(Color.GREEN);
        img.fillRect(1, 1, filledAmount, height - 2);
        setImage(img);
        
    }
    public void act()
    {
        int w = worldRef.getTotalWeight();
        setValue(w);
        
    }
}
