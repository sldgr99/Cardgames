package it.unicam.cs.pa2021.cardgames.util.controller.table;

import it.unicam.cs.pa2021.cardgames.util.model.cards.ICard;
import it.unicam.cs.pa2021.cardgames.util.model.player.IPlayer;
import it.unicam.cs.pa2021.cardgames.util.model.player.SimpleIPlayer;
import it.unicam.cs.pa2021.cardgames.util.model.cards.IRank;
import it.unicam.cs.pa2021.cardgames.util.model.cards.SimpleICard;
import it.unicam.cs.pa2021.cardgames.util.model.cards.ISuit;
import it.unicam.cs.pa2021.cardgames.util.model.deck.SimpleIDeck;

import java.util.List;

/**
 * Interfaccia che rappresenta un generico campo da gioco
 *
 * @param <T> la tipologia di carte ammesse nel tavolo
 */
public interface IGameTable<T extends ICard<? extends IRank, ? extends ISuit>, P extends IPlayer<?>> {

    /**
     * Metodo che permette il settaggio di un deck all'interno del campo da gioco
     *
     * @param deck il mazzo da aggiungere
     */
    void setDeck(SimpleIDeck<T> deck);

    /**
     * Metodo che permette l'aggiunta dei giocatori all'interno del campo
     *
     * @param player il giocatore che vuole aggiungersi
     */
    void addPlayer(P player);

    /**
     * Metodo che permette la rimozione dei giocatori all'interno del campo
     *
     * @param player il giocatore che deve essere rimosso
     */
    void removePayer(P player);

    /**
     * Metodo che permette la start del gioco all'interno del tavolo da gioco
     *
     */
    void startGame();


    /**
     * Metodo che ritorna il numero di giocatori presenti all'interno del tavolo da gioco
     *
     * @return il numero di giocatori presenti
     */
    int getNumberPlayer();


    /**
     * Metodo che ritorna il mazzo usato
     *
     * @return il mazzo usato nel gioco
     */
    SimpleIDeck<T> getDeck();

    /**
     * Metodo che ritorna i giocatori all'interno del tavolo
     *
     * @return i giocatori sul tavolo
     */
    List<P> getPlayers();

}
