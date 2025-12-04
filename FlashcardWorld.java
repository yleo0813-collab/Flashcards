import greenfoot.*;
import java.util.*;
import java.io.*;

public class FlashcardWorld extends World {
    private ArrayList<Flashcard> csvData;
    
    private Integer cardIndex = 0;
    private Flashcard currentCard;
    private boolean firstTime = true;
    private Integer index = 0;
    
    private int totalWeight = 0;
    private BarTwo secondBar;
    private ProgressBar bar;
    private SecondBar barTwo;
    private String selectedFileName;
    //Establishes the interface of the world and transports the input file to a file called csvData


    public FlashcardWorld(String selectedFileName) {
        super(600, 400, 1);
        this.selectedFileName = selectedFileName;
        
        bar = new ProgressBar(200, 30, 100);
        addObject(bar, 300, 100);
        bar.setValue(100);
        
        barTwo = new SecondBar(200, 30, 100);
        addObject(barTwo, 300, 50);
        barTwo.setValue(100);

        csvData = new ArrayList<>();
        readDataFromCSV("cards/" + selectedFileName);
        

        if (!csvData.isEmpty()) {
            showCard(0); 
        } else {
            System.out.println("No data found in CSV file!");
        }
        
        int totalLength = csvData.size();
        
  
        addObject(new Exit(), 500, 350);
        addObject(new Button1(this), 150, 300);
        addObject(new Button2(this), 450, 300);
        addObject(new SignOne(this), 100, 50);
        addObject(new SignTwo(this), 100, 100);
    }
    
   
    public void updateProgress() {
            
        int fillPercentage = 0;
        if(currentCard.getWrong() + currentCard.getCorrect() > 0){
            
            fillPercentage = (currentCard.getCorrect()*100)/(currentCard.getWrong() + currentCard.getCorrect());
        }
        bar.setValue(fillPercentage);
        barTwo.setValue(percentageAsked());
    }
    
    
    
    
    //Outputs a percentage of cards that have been asked 
    
    public int percentageAsked(){
        Integer x=0;
        for(Flashcard f: csvData){
            if(f.getAsked() != 0){
                x++;
            }
        }
        return x*100/(csvData.size());
    }
                
           
        
    





    
    //Calculates the number of times a card should be displayed (active recall)
    public int getTotalWeight(){
        return totalWeight;
    }
    
    public Integer getNumber(Flashcard currentCard){
        if(currentCard.getAsked() ==0){
            return 5;
        }
        else if(currentCard.getWrong() - currentCard.getCorrect() > 0){
            return 10 * (currentCard.getWrong() - currentCard.getCorrect());
        }
        else if(currentCard.getCorrect() >= 1){
            return 2;
        }
        return 5;
    }
    
    
        
    
    
    
    
    //Display the card at a particular position (prepare for later programming)
    public void showCard(int index){
        
        //Checks that the card will have a backup before getting it away
        if(currentCard != null && currentCard.getWorld() != null){
            removeObject(currentCard);
        }
        
        //Displays the card onto the screen
        currentCard = csvData.get(index);
        addObject(currentCard, getWidth()/2, getHeight()/2);
        
        
        //Marks that it has been shown 
        currentCard.getAsked();
        updateProgress ();
        
        
    }
    
    
    //Generic function to get a card displayed (from the original file)

 
    public void showNextCard() {
        
        totalWeight = 0;
        
        
        //Goes through all the flashcards in csv
        for(Flashcard f: csvData){
            totalWeight += getNumber(f);
            
            //Gets a sum of all the cards in the deck
        }
        
        
        
        //Makes sure that something is there
        if(totalWeight <= 0){
            showCard(0);
            return;
        }
        
        
        
        int r = Greenfoot.getRandomNumber(totalWeight);
        
        Flashcard chosen = null;
        int cumulative = 0;
        
        
        
        
        
        for(Flashcard f: csvData){
            
            //Add to the total number of cards there should be
            cumulative += getNumber(f);
            
            //Chooses an actual card from the pool 
            
            //the random value has to be smaller than the total number of cards for it to work
            if(r < cumulative){
                chosen = f;
                break;
            }
        }
        
        //Displays a default
        
        if(chosen == null){
            chosen = csvData.get(0);
        }
        
        
        //Same safety check
        if(currentCard != null && currentCard.getWorld() != null){
            removeObject(currentCard);
        }
        
        //Displays the card on the screen
        currentCard = chosen;
        addObject(currentCard, getWidth()/2, getHeight()/2);
        
        currentCard.setAsked();
        updateProgress ();
        
        

    }

    
    //Generic operator to read the input file (already called on top)
  
    private void readDataFromCSV(String filename) {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(filename));
            String line;

        
            br.readLine();

            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) continue;

                
                String[] parts = line.split(",", 2);
                if (parts.length < 2) continue;

                String question = parts[0].trim();
                String answer   = parts[1].trim();

                csvData.add(new Flashcard( question, answer ));
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filename);
        } catch (IOException e) {
            System.out.println("IO error: " + e.getMessage());
        } finally {
            try { if (br != null) br.close(); } catch (IOException ignored) {}
        }
    }
    public Flashcard getCurrentCard(){
        return currentCard;
    }
}
