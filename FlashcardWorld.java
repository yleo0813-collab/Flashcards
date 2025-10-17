import greenfoot.*;

public class FlashcardWorld extends World {
    //private Flashcard currentCard;
    private String[][] cards = {
        {"Capital of France?", "Paris"},
        {"Germany", "Berlin"}
    };
    private int cardIndex = 0;

    public FlashcardWorld() {
        super(300, 400, 1);
        
        addObject(new Flashcard(cards[0][0],cards[0][1],new GreenfootImage("bananas.png")), 150,200);
        
        addObject(new Exit(), 235, 400);
        
        addObject(new Button1(), 70, 300);
        addObject(new Button2(), 400, 300);
    }
/*
    public void showNextCard() {
        if (cardIndex < cards.length) {
            if (currentCard != null) removeObject(currentCard);
            currentCard = new Flashcard(cards[cardIndex][0], cards[cardIndex][1]);
            addObject(currentCard, getWidth()/2, getHeight()/2);
            cardIndex++;
        } else {
            showText("No more cards!", getWidth()/2, getHeight()/2);
        }
    }
    */
}

