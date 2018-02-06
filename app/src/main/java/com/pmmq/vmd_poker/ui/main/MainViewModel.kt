package com.pmmq.vmd_poker.ui.main

import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import com.pmmq.vmd_poker.BR
import com.pmmq.vmd_poker.data.model.Card
import com.pmmq.vmd_poker.data.model.Deck
import com.pmmq.vmd_poker.data.model.Player
import com.pmmq.vmd_poker.databinding.ActivityMainBinding


/**
 * Created by pmmq on 2/6/2018.
 */


class MainViewModel() : ViewModel() {
    // todo : implement live data for dynamic view
    var firstPlayer:Player
    var secondPlayer:Player
    var deck:Deck
    var dataBinding:ActivityMainBinding? = null
    var status: String? = ""
    init{
        deck = Deck()
        firstPlayer = Player("Somchai",ArrayList<Card>())
        secondPlayer = Player("Somsak",ArrayList<Card>())
        newGame()
    }

    companion object{
        fun create(activity: AppCompatActivity): MainViewModel{
            var productDetailViewModel = ViewModelProviders.of(activity).get(MainViewModel::class.java)
            return productDetailViewModel
        }
    }

    public fun onNewGameClick(view: View){
        newGame()
    }

    public fun newGame(){
        if (deck.cards.size < 52) deck.initDeck()
        deck.shuffle()
        dealOutCard()
        firstPlayer.compute()
        secondPlayer.compute()
        status = when{
            firstPlayer.mHandType.priority > secondPlayer.mHandType.priority ||
                    (firstPlayer.mHandType.priority == secondPlayer.mHandType.priority &&
                            firstPlayer.mHighCard.point.value > secondPlayer.mHighCard.point.value)  -> {
                "${firstPlayer.mName} wins - with ${firstPlayer.mHandType.toString()}"
            }
            firstPlayer.mHandType.priority < secondPlayer.mHandType.priority ||
                    (firstPlayer.mHandType.priority == secondPlayer.mHandType.priority &&
                            firstPlayer.mHighCard.point.value < secondPlayer.mHighCard.point.value) -> {
                "${secondPlayer.mName} wins - with ${secondPlayer.mHandType.toString()}"
            }
            else -> "Tie ${firstPlayer.mHandType.toString()}"
        }
        dataBinding?.viewModel = this
    }

    private fun dealOutCard(){
        firstPlayer.mHand.clear()
        secondPlayer.mHand.clear()
//        firstPlayer.mHand.add(Card(Card.Suit.C,Card.Value.SIX))
//        firstPlayer.mHand.add(Card(Card.Suit.H,Card.Value.TWO))
//        firstPlayer.mHand.add(Card(Card.Suit.D,Card.Value.EIGHT))
//        firstPlayer.mHand.add(Card(Card.Suit.S,Card.Value.FOUR))
//        firstPlayer.mHand.add(Card(Card.Suit.S,Card.Value.FIVE))
//
//        secondPlayer.mHand.add(Card(Card.Suit.H,Card.Value.SIX))
//        secondPlayer.mHand.add(Card(Card.Suit.C,Card.Value.TWO))
//        secondPlayer.mHand.add(Card(Card.Suit.S,Card.Value.EIGHT))
//        secondPlayer.mHand.add(Card(Card.Suit.D,Card.Value.FOUR))
//        secondPlayer.mHand.add(Card(Card.Suit.D,Card.Value.FIVE))

        // enable auto deal out card
//        firstPlayer.mHand.add(deck.draw())
//        secondPlayer.mHand.add(deck.draw())
//        firstPlayer.mHand.add(deck.draw())
//        secondPlayer.mHand.add(deck.draw())
//        firstPlayer.mHand.add(deck.draw())
//        secondPlayer.mHand.add(deck.draw())
//        firstPlayer.mHand.add(deck.draw())
//        secondPlayer.mHand.add(deck.draw())
//        firstPlayer.mHand.add(deck.draw())
//        secondPlayer.mHand.add(deck.draw())
    }

    public fun bind(){
        dataBinding?.viewModel = this
    }

    protected override fun onCleared() {
        super.onCleared()
    }
}