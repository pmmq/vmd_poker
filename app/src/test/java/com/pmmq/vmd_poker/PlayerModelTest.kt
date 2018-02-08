package com.pmmq.vmd_poker

import com.pmmq.vmd_poker.data.model.Card
import com.pmmq.vmd_poker.data.model.Deck
import com.pmmq.vmd_poker.data.model.Player
import org.junit.Assert
import org.junit.Before
import org.junit.Test

/**
 * Created by Pub on 09/02/2018.
 */
class PlayerModelTest() {
    lateinit var player: Player
    var deck = Deck()

    val highCard = arrayListOf<Card>(getCard(Card.Suit.H, Card.Value.ACE),
            getCard(Card.Suit.S, Card.Value.SEVEN),
            getCard(Card.Suit.H, Card.Value.TEN),
            getCard(Card.Suit.D, Card.Value.TWO),
            getCard(Card.Suit.H, Card.Value.TREE))
    val onePair = arrayListOf<Card>(getCard(Card.Suit.H, Card.Value.ACE),
            getCard(Card.Suit.S, Card.Value.ACE),
            getCard(Card.Suit.H, Card.Value.TEN),
            getCard(Card.Suit.D, Card.Value.TWO),
            getCard(Card.Suit.H, Card.Value.TREE))
    val twoPair = arrayListOf<Card>(getCard(Card.Suit.H, Card.Value.ACE),
            getCard(Card.Suit.S, Card.Value.ACE),
            getCard(Card.Suit.H, Card.Value.TEN),
            getCard(Card.Suit.D, Card.Value.TEN),
            getCard(Card.Suit.H, Card.Value.TREE))
    val treeCard = arrayListOf<Card>(getCard(Card.Suit.D, Card.Value.ACE),
            getCard(Card.Suit.S, Card.Value.ACE),
            getCard(Card.Suit.H, Card.Value.ACE),
            getCard(Card.Suit.D, Card.Value.TWO),
            getCard(Card.Suit.H, Card.Value.TREE))
    val fourCard = arrayListOf<Card>(getCard(Card.Suit.H, Card.Value.ACE),
            getCard(Card.Suit.S, Card.Value.ACE),
            getCard(Card.Suit.D, Card.Value.ACE),
            getCard(Card.Suit.C, Card.Value.ACE),
            getCard(Card.Suit.H, Card.Value.TREE))
    val flushCard = arrayListOf<Card>(getCard(Card.Suit.H, Card.Value.ACE),
            getCard(Card.Suit.H, Card.Value.SEVEN),
            getCard(Card.Suit.H, Card.Value.TEN),
            getCard(Card.Suit.H, Card.Value.TWO),
            getCard(Card.Suit.H, Card.Value.TREE))
    val straightCard = arrayListOf<Card>(getCard(Card.Suit.H, Card.Value.ACE),
            getCard(Card.Suit.S, Card.Value.TWO),
            getCard(Card.Suit.H, Card.Value.TREE),
            getCard(Card.Suit.D, Card.Value.FIVE),
            getCard(Card.Suit.H, Card.Value.FOUR))
    val fullHouse = arrayListOf<Card>(getCard(Card.Suit.H, Card.Value.ACE),
            getCard(Card.Suit.S, Card.Value.ACE),
            getCard(Card.Suit.H, Card.Value.ACE),
            getCard(Card.Suit.D, Card.Value.TWO),
            getCard(Card.Suit.H, Card.Value.TWO))
    val straighFlush = arrayListOf<Card>(getCard(Card.Suit.H, Card.Value.SIX),
            getCard(Card.Suit.H, Card.Value.SEVEN),
            getCard(Card.Suit.H, Card.Value.EIGHT),
            getCard(Card.Suit.H, Card.Value.NINE),
            getCard(Card.Suit.H, Card.Value.TEN))


    @Before
    fun setup() {
        val hand = ArrayList<Card>()
        val name = "Pub"
        player = Player(name, hand)
    }

    @Test
    fun testComputeHandCard() {
        val hands = arrayOf(highCard, onePair, twoPair,
                treeCard, fourCard, fullHouse,
                straightCard, flushCard, straighFlush)
        val types = arrayOf(Player.HandType.HIGH_SCORE,
                Player.HandType.ONE_PAIR,
                Player.HandType.TWO_PAIR,
                Player.HandType.TREE_CARD,
                Player.HandType.FOUR_CARD,
                Player.HandType.FULL_HOUSE,
                Player.HandType.STRAIGHT,
                Player.HandType.FLUSH,
                Player.HandType.STRAIGHT_FLUSH)
        for ((index,hand) in hands.withIndex()) {
            player.mHand = hand
            player.compute()
            Assert.assertEquals(player.mHandType, types[index])
        }
    }

    fun getCard(suit: Card.Suit, point: Card.Value): Card {
        return deck.cards.first { it.point == point && it.suit == suit }
    }
}