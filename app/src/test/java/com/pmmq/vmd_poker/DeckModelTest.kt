package com.pmmq.vmd_poker

import com.pmmq.vmd_poker.data.model.Deck
import org.junit.Assert
import org.junit.Before
import org.junit.Test

/**
 * Created by Pub on 09/02/2018.
 */
class DeckModelTest(){

    var deck = Deck()

    @Before
    fun setup(){
        deck.initDeck()
    }

    @Test
    fun initWithCorrectData(){
        Assert.assertTrue(deck.cards.size == 52)
        Assert.assertEquals(deck.cards.get(0).getCardName(), "ACE of C")
        Assert.assertEquals(deck.cards.get(13).getCardName(), "ACE of D")
        Assert.assertEquals(deck.cards.get(26).getCardName(), "ACE of H")
        Assert.assertEquals(deck.cards.get(39).getCardName(), "ACE of S")
    }

    @Test
    fun suffleCorrect(){
        deck.shuffle()
        var compareDeck = Deck()
        compareDeck.initDeck()
        // must not be match in row of init card
        val isMatch = deck.cards.get(0).getCardName().equals(compareDeck.cards.get(0).getCardName()) &&
                deck.cards.get(1).getCardName().equals(compareDeck.cards.get(1).getCardName()) &&
                deck.cards.get(2).getCardName().equals(compareDeck.cards.get(2).getCardName()) &&
                deck.cards.get(3).getCardName().equals(compareDeck.cards.get(3).getCardName()) &&
                deck.cards.get(4).getCardName().equals(compareDeck.cards.get(4).getCardName()) &&
                deck.cards.get(5).getCardName().equals(compareDeck.cards.get(5).getCardName()) &&
                deck.cards.get(6).getCardName().equals(compareDeck.cards.get(6).getCardName()) &&
                deck.cards.get(7).getCardName().equals(compareDeck.cards.get(7).getCardName())
        Assert.assertFalse(isMatch)
    }

    @Test
    fun drawWorkCorrect(){
        var drawCard = deck.draw()
        // size must be 51
        Assert.assertTrue(deck.cards.size == 51)
        // card already take out it mean can't find this card in deck anymore
        Assert.assertTrue(deck.cards.indexOf(drawCard) == -1)
    }

}