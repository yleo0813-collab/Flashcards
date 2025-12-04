import greenfoot.*;

public class Flashcard extends Actor {
    private String Question;
    private String Answer;
    private Integer Correct = 0;
    private Integer Wrong = 0;
    private Integer Asked = 0;
    private GreenfootImage frontImage;
    private GreenfootImage backImage;
    private boolean isFaceUp;
    
    
    
    

    public Flashcard(String question, String answer) {
        this.Question = question;
        this.Answer = answer;
        

        // Create front image (question side)
        frontImage = new GreenfootImage(300, 150);
        frontImage.setColor(Color.WHITE);
        frontImage.fill();
        frontImage.setColor(Color.BLACK);
        frontImage.drawRect(0, 0, 299, 149);
        frontImage.drawString(question, 20, 75);

        // Create back image (answer side)
        backImage = new GreenfootImage(300, 150);
        backImage.setColor(Color.LIGHT_GRAY);
        backImage.fill();
        backImage.setColor(Color.BLACK);
        backImage.drawRect(0, 0, 299, 149);
        backImage.drawString(answer, 20, 75);

        // Start face-down (showing question)
        setImage(frontImage);
        isFaceUp = true;
    }
    
    private String getQuestion(){
        return Question;
    }
    
    private void setQuestion(String question){
        this.Question = question;
    }
    
    private String getAnswer(){
        return Answer;
    }
    
    private void setAnswer(String answer){
        this.Answer = answer;
    }
    
    public void setCorrect(){
        Correct++;
    }
    
    public Integer getCorrect(){
        return Correct;
    }
    public void setWrong(){
        Wrong++;
    }
    public Integer getWrong(){
        return Wrong;
    }
    public void setAsked(){
        Asked ++;
    }
    public Integer getAsked(){
        return Asked;
    }
    
   
    
    
    
    
    

    

    

    public void flip() {
        if (isFaceUp) {
            setImage(backImage); 
        } else {
            setImage(frontImage); 
        }
        isFaceUp = !isFaceUp; 
    }

    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            flip();
        }
    }
}

