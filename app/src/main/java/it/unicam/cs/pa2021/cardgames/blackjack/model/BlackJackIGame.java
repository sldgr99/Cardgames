package it.unicam.cs.pa2021.cardgames.blackjack.model;

import it.unicam.cs.pa2021.cardgames.util.model.cards.Face;
import it.unicam.cs.pa2021.cardgames.util.model.cards.FrenchICard;
import it.unicam.cs.pa2021.cardgames.util.model.cards.FrenchIRank;
import it.unicam.cs.pa2021.cardgames.util.model.cards.FrenchISuit;
import it.unicam.cs.pa2021.cardgames.util.model.game.IGame;

import java.util.List;


public class BlackJackIGame implements IGame<FrenchICard, BlackJackIDeck> {

    private BlackJackIDeck deck;

    public BlackJackIGame(){
        deck = new BlackJackIDeck();
    }

    @Override
    public BlackJackIDeck start() {
        return deck = initializeDeck();
    }

    @Override
    public BlackJackIDeck initializeDeck(){
        for (FrenchISuit s : FrenchISuit.values()){
            for (FrenchIRank r: FrenchIRank.values()){
                deck.addCard(new FrenchICard(r, s), deck.size());
            }
        }
        return deck;
    }

    /**
     * Metodo che controlla se in una mano il numero di carte risulta maggiore di 21
     *
     * @param mano dalla quale controllare
     * @return true se lo supero else false
     */
    public int calculateHand(List<FrenchICard> mano){
        int total = 0;
        for(FrenchICard single: mano){
            if(single.getFace().equals(Face.DOWN))  single.setFace(Face.UP);
            int valueCard = single.getRank().get().getBjValue();
            total += valueCard;
        }
        return total;
    }
}
