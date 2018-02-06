package com.pmmq.vmd_poker.data.model

import java.util.*

/**
 * Created by pmmq on 2/6/2018.
 */
class Deck {
    val cards = arrayListOf<Card>()
    val random = Random();
    init {
        initDeck()
    }

    public fun initDeck(){
        cards.clear()
        // club
        cards.add(Card(Card.Suit.C, Card.Value.ACE))
        cards.add(Card(Card.Suit.C, Card.Value.TWO))
        cards.add(Card(Card.Suit.C, Card.Value.TREE))
        cards.add(Card(Card.Suit.C, Card.Value.FOUR))
        cards.add(Card(Card.Suit.C, Card.Value.FIVE))
        cards.add(Card(Card.Suit.C, Card.Value.SIX))
        cards.add(Card(Card.Suit.C, Card.Value.SEVEN))
        cards.add(Card(Card.Suit.C, Card.Value.EIGHT))
        cards.add(Card(Card.Suit.C, Card.Value.NINE))
        cards.add(Card(Card.Suit.C, Card.Value.TEN))
        cards.add(Card(Card.Suit.C, Card.Value.JACK))
        cards.add(Card(Card.Suit.C, Card.Value.QUEEN))
        cards.add(Card(Card.Suit.C, Card.Value.KING))
        // diamon
        cards.add(Card(Card.Suit.D, Card.Value.ACE))
        cards.add(Card(Card.Suit.D, Card.Value.TWO))
        cards.add(Card(Card.Suit.D, Card.Value.TREE))
        cards.add(Card(Card.Suit.D, Card.Value.FOUR))
        cards.add(Card(Card.Suit.D, Card.Value.FIVE))
        cards.add(Card(Card.Suit.D, Card.Value.SIX))
        cards.add(Card(Card.Suit.D, Card.Value.SEVEN))
        cards.add(Card(Card.Suit.D, Card.Value.EIGHT))
        cards.add(Card(Card.Suit.D, Card.Value.NINE))
        cards.add(Card(Card.Suit.D, Card.Value.TEN))
        cards.add(Card(Card.Suit.D, Card.Value.JACK))
        cards.add(Card(Card.Suit.D, Card.Value.QUEEN))
        cards.add(Card(Card.Suit.D, Card.Value.KING))
        // heart
        cards.add(Card(Card.Suit.H, Card.Value.ACE))
        cards.add(Card(Card.Suit.H, Card.Value.TWO))
        cards.add(Card(Card.Suit.H, Card.Value.TREE))
        cards.add(Card(Card.Suit.H, Card.Value.FOUR))
        cards.add(Card(Card.Suit.H, Card.Value.FIVE))
        cards.add(Card(Card.Suit.H, Card.Value.SIX))
        cards.add(Card(Card.Suit.H, Card.Value.SEVEN))
        cards.add(Card(Card.Suit.H, Card.Value.EIGHT))
        cards.add(Card(Card.Suit.H, Card.Value.NINE))
        cards.add(Card(Card.Suit.H, Card.Value.TEN))
        cards.add(Card(Card.Suit.H, Card.Value.JACK))
        cards.add(Card(Card.Suit.H, Card.Value.QUEEN))
        cards.add(Card(Card.Suit.H, Card.Value.KING))
        // spade
        cards.add(Card(Card.Suit.S, Card.Value.ACE))
        cards.add(Card(Card.Suit.S, Card.Value.TWO))
        cards.add(Card(Card.Suit.S, Card.Value.TREE))
        cards.add(Card(Card.Suit.S, Card.Value.FOUR))
        cards.add(Card(Card.Suit.S, Card.Value.FIVE))
        cards.add(Card(Card.Suit.S, Card.Value.SIX))
        cards.add(Card(Card.Suit.S, Card.Value.SEVEN))
        cards.add(Card(Card.Suit.S, Card.Value.EIGHT))
        cards.add(Card(Card.Suit.S, Card.Value.NINE))
        cards.add(Card(Card.Suit.S, Card.Value.TEN))
        cards.add(Card(Card.Suit.S, Card.Value.JACK))
        cards.add(Card(Card.Suit.S, Card.Value.QUEEN))
        cards.add(Card(Card.Suit.S, Card.Value.KING))
    }

    public fun shuffle(){
        for (i in 1..1000){
            Collections.swap(cards,random.nextInt(cards.size),random.nextInt(cards.size));
        }
    }

    public fun draw(): Card{
        val retCard = cards.get(0);
        cards.removeAt(0)
        return retCard
    }
}