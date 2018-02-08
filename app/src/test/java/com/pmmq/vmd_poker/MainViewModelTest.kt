package com.pmmq.vmd_poker

import com.pmmq.vmd_poker.data.model.Card
import com.pmmq.vmd_poker.data.model.Deck
import com.pmmq.vmd_poker.ui.main.MainViewModel
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

/**
 * Created by Pub on 09/02/2018.
 */
class  MainViewModelTest(){

    lateinit var mainViewModel:MainViewModel

    var deck = Deck()

    val firstPlayerfirstCase = arrayListOf<Card>(getCard(Card.Suit.H, Card.Value.ACE),
            getCard(Card.Suit.S, Card.Value.SEVEN),
            getCard(Card.Suit.H, Card.Value.TEN),
            getCard(Card.Suit.D, Card.Value.TWO),
            getCard(Card.Suit.H, Card.Value.TREE))
    val secondPlayerfirstCase = arrayListOf<Card>(getCard(Card.Suit.H, Card.Value.ACE),
            getCard(Card.Suit.S, Card.Value.SEVEN),
            getCard(Card.Suit.H, Card.Value.TEN),
            getCard(Card.Suit.D, Card.Value.TWO),
            getCard(Card.Suit.H, Card.Value.TREE))
    val firstPlayersecondCase = arrayListOf<Card>(getCard(Card.Suit.H, Card.Value.ACE),
            getCard(Card.Suit.S, Card.Value.ACE),
            getCard(Card.Suit.D, Card.Value.ACE),
            getCard(Card.Suit.C, Card.Value.ACE),
            getCard(Card.Suit.H, Card.Value.TREE))
    val secondPlayersecondCase = arrayListOf<Card>(getCard(Card.Suit.D, Card.Value.ACE),
            getCard(Card.Suit.S, Card.Value.JACK),
            getCard(Card.Suit.H, Card.Value.ACE),
            getCard(Card.Suit.D, Card.Value.ACE),
            getCard(Card.Suit.H, Card.Value.TREE))
    val firstPlayerthirdCase = arrayListOf<Card>(getCard(Card.Suit.H, Card.Value.ACE),
            getCard(Card.Suit.S, Card.Value.ACE),
            getCard(Card.Suit.D, Card.Value.ACE),
            getCard(Card.Suit.C, Card.Value.ACE),
            getCard(Card.Suit.H, Card.Value.TREE))
    val secondPlayerthirdCaseCard = arrayListOf<Card>(getCard(Card.Suit.H, Card.Value.ACE),
            getCard(Card.Suit.H, Card.Value.TWO),
            getCard(Card.Suit.H, Card.Value.TREE),
            getCard(Card.Suit.H, Card.Value.FOUR),
            getCard(Card.Suit.H, Card.Value.FIVE))

    @Before
    fun setup(){
        MockitoAnnotations.initMocks(this)
        mainViewModel = MainViewModel()
        mainViewModel.newGame()
    }

    @Test
    fun initCorrectly(){
        Assert.assertNotEquals(mainViewModel.mStatus,"")
        Assert.assertEquals(mainViewModel.mFirstPlayer.get().mName,"Somchai")
        Assert.assertEquals(mainViewModel.mSecondPlayer.get().mName,"Somsak")
    }

    @Test
    fun dealoutCardCorrectly(){
        Assert.assertEquals(mainViewModel.mFirstPlayer.get().mHand.size,5);
        Assert.assertEquals(mainViewModel.mSecondPlayer.get().mHand.size,5);
    }

    @Test
    fun checkStatusTieCase(){
        val spyViewModel = Mockito.spy(mainViewModel)
        Mockito.doNothing().`when`(spyViewModel)
                .dealOutCard()
                .apply {
                    spyViewModel.mFirstPlayer.get().mHand = firstPlayerfirstCase
                    spyViewModel.mSecondPlayer.get().mHand = secondPlayerfirstCase
                }
        spyViewModel.newGame()
        Assert.assertEquals(spyViewModel.mStatus.get(),"Tie ${spyViewModel.mFirstPlayer.get().mHandType.toString()}")
    }

    @Test
    fun checkStatusFirstPlayer(){
        val spyViewModel = Mockito.spy(mainViewModel)
        Mockito.doNothing().`when`(spyViewModel)
                .dealOutCard()
                .apply {
                    spyViewModel.mFirstPlayer.get().mHand = firstPlayersecondCase
                    spyViewModel.mSecondPlayer.get().mHand = secondPlayersecondCase
                }
        spyViewModel.newGame()
        Assert.assertEquals(spyViewModel.mStatus.get(),"${spyViewModel.mFirstPlayer.get().mName} wins - with ${spyViewModel.mFirstPlayer.get().mHandType.toString()}")
    }

    @Test
    fun checkStatusSecondPlayerWin(){
        val spyViewModel = Mockito.spy(mainViewModel)
        Mockito.doNothing().`when`(spyViewModel)
                .dealOutCard()
                .apply {
                    spyViewModel.mFirstPlayer.get().mHand = firstPlayerthirdCase
                    spyViewModel.mSecondPlayer.get().mHand = secondPlayerthirdCaseCard
                }
        spyViewModel.newGame()
        Assert.assertEquals(spyViewModel.mStatus.get(),"${spyViewModel.mSecondPlayer.get().mName} wins - with ${spyViewModel.mSecondPlayer.get().mHandType.toString()}")
    }

    fun getCard(suit: Card.Suit, point: Card.Value): Card {
        return deck.cards.first { it.point == point && it.suit == suit }
    }

}