import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MenuWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MenuWorld extends World
{
    private String selectedFileName;

    /**
     * Constructor for objects of class MenuWorld.
     * 
     */
    public MenuWorld(String selectedFileName)
    {    
        super(600, 400, 1);
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels
        this.selectedFileName = selectedFileName; 
        showText("Welcome to Repetition Cards!", 300, 100);
        addObject(new BackButton(selectedFileName), 300, 200);
        prepare();
    }
    
    public void act(){
        if(Greenfoot.mouseClicked(this)){
            Greenfoot.setWorld(new SelectionInterface());
        }
    }
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
    }
}
