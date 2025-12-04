import greenfoot.*; 
import java.io.File;
import java.awt.Color; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SelectionInterface here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SelectionInterface extends World
{

    /**
     * Constructor for objects of class SelectionInterface.
     * 
     */
    public SelectionInterface()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        showText("Please Make a Selection", 300, 50);
        File folder = new File("cards/");
        File[] files = folder.listFiles();
        
        int y = 120;
        for(File f: files){
            if(f.getName().endsWith(".csv")){
                String holderObject = f.getName().replace(".csv", "");
                addObject(new FileOptions(holderObject), 300, y);
                y+=40;
            }
        }
    }
}
