import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SecondBar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SecondBar extends Actor
{
    private int width;
    private int height;
    private int maxValue;
    private int value;
    /**
     * Act - do whatever the SecondBar wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public SecondBar(int width, int height, int maxValue){
        this.width = width;
        this.height = height;
        this.maxValue = maxValue;
        this.value = 0;
        updateImage();
    
    }
    public void setValue(int newValue){
        value = Math.max(0, Math.min(newValue, maxValue));
        updateImage();
    }
    
    private void updateImage() {
        // base image for the bar
        GreenfootImage img = new GreenfootImage(width, height);

        // background
        img.setColor(Color.WHITE);
        img.fillRect(0, 0, width, height);

        // filled portion
        double ratio = (double) value / maxValue;
        int filledWidth = (int) (width * ratio);

        img.setColor(Color.GREEN);
        img.fillRect(0, 0, filledWidth, height);

        // border
        img.setColor(Color.BLACK);
        img.drawRect(0, 0, width - 1, height - 1);

        // percentage text
        int percent = (int) (100.0 * value / maxValue);
        String text = percent + "%";

        // text image (Greenfoot handles centering for us)
        int fontSize = height - 6; // scale font to bar height
        if (fontSize < 10) fontSize = 10; // minimum readable size

        GreenfootImage textImg = new GreenfootImage(text, fontSize, Color.BLACK, null);
        int textX = (width - textImg.getWidth()) / 2;
        int textY = (height - textImg.getHeight()) / 2;

        img.drawImage(textImg, textX, textY);

        setImage(img);
    }
    public void act()
    {
        // Add your action code here.
    }
}
