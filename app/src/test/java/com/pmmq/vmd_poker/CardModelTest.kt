package com.pmmq.vmd_poker

import com.pmmq.vmd_poker.data.model.Card
import org.junit.Assert
import org.junit.Test
import org.junit.rules.Verifier
import org.mockito.Mockito

/**
 * Created by Pub on 09/02/2018.
 */

class CardModelTest(){

    private val mCard = Card(Card.Suit.C,Card.Value.ACE)

    @Test
    fun getCardNameCorrectFormat() {
        var cardName = mCard.getCardName()
        Assert.assertTrue(cardName.contains("of"))
        Assert.assertTrue(cardName.contains(Card.Suit.C.toString()))
        Assert.assertTrue(cardName.contains(Card.Value.ACE.toString()))
    }
}
