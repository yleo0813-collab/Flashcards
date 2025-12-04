import greenfoot.*; 
import greenfoot.Color; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class FileOptions here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FileOptions extends Actor
{
    /**
     * Act - do whatever the FileOptions wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    private String selectedFileName;
    
    public FileOptions(String filename){
        this.selectedFileName = filename;
        GreenfootImage img = new GreenfootImage(filename, 24, Color.WHITE, new Color(0, 0, 0, 0));
        setImage(img);
    }
    
    public void act()
    
    {
        if(Greenfoot.mouseClicked(this)){
            Greenfoot.setWorld(new MenuWorld(selectedFileName+".csv"));
        }
    }
}
