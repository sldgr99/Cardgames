/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package it.unicam.cs.pa2021.cardgames;

import it.unicam.cs.pa2021.cardgames.blackjack.controller.Engine;
import it.unicam.cs.pa2021.cardgames.blackjack.model.BlackJackDealer;
import it.unicam.cs.pa2021.cardgames.blackjack.model.BlackJackIDeck;
import it.unicam.cs.pa2021.cardgames.blackjack.model.BlackJackIGame;
import it.unicam.cs.pa2021.cardgames.blackjack.model.BlackJackIPlayer;
import it.unicam.cs.pa2021.cardgames.blackjack.view.BlackJackTable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class App {

    public static void main(String[] args) throws IOException {
        BlackJackIPlayer player1 = new BlackJackIPlayer("giorgio", 1);
        BlackJackIPlayer player2 = new BlackJackIPlayer("greenducci", 2);
        BlackJackIDeck deckBj = new BlackJackIDeck();
        BlackJackIGame bjGame = new BlackJackIGame();
        BlackJackTable bjTable = new BlackJackTable(deckBj, bjGame);
        bjTable.startGame();
        bjTable.addPlayer(player1);
        bjTable.addPlayer(player2);
        BlackJackDealer dealer = new BlackJackDealer("spina", 3);
        bjTable.addDealer(dealer);
        String restart = "yes";
        while(restart.equals("yes") || (restart.equals("1"))){
            Engine gioco = new Engine(bjTable);
            gioco.clearHand(bjTable);
            gioco.shuffleDeck(bjTable);
            try {
                gioco.askBet(bjTable);
            } catch (IOException e) {
                e.printStackTrace();
            }
            gioco.dealCards(bjTable);
            gioco.makeChoise(bjTable);
            gioco.evaluateWinner(bjTable);
            System.out.println("Vuoi rigiocare una partita? 1-yes 2-no");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            restart = reader.readLine();
        }
        System.out.println("Partita terminata con "+player1.getNome()+" avente "+player1.getBank()+" coin");
        System.out.println("Partita terminata con "+player2.getNome()+" avente "+player2.getBank()+" coin");
    }
}

