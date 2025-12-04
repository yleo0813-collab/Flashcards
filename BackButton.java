import greenfoot.*;

public class BackButton extends Actor
{
    private String selectedFileName;
    public BackButton(String selectedFileName)
    {
        this.selectedFileName = selectedFileName;
        
        GreenfootImage img = new GreenfootImage("Click Here to Begin Journey", 30, Color.BLACK, new Color(0,0,0,0));
        setImage(img);
    }

    public void act()
    {
        if(Greenfoot.mouseClicked(this)){
            Greenfoot.setWorld(new FlashcardWorld(selectedFileName));
        }
    }
}


