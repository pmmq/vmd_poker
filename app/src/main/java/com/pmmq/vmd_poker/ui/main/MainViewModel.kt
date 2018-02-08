package com.pmmq.vmd_poker.ui.main

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProviders
import android.databinding.ObservableField
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.pmmq.vmd_poker.data.model.Card
import com.pmmq.vmd_poker.data.model.Deck
import com.pmmq.vmd_poker.data.model.Player
import com.pmmq.vmd_poker.databinding.ActivityMainBinding


/**
 * Created by pmmq on 2/6/2018.
 */


class MainViewModel() : ViewModel() {
    // todo : implement live data for dynamic view
    var mFirstPlayer: ObservableField<Player>
    var mSecondPlayer: ObservableField<Player>
    var mDeck: Deck
    var mDataBinding: ActivityMainBinding? = null
    var mStatus: ObservableField<String>

    init {
        mDeck = Deck()
        mFirstPlayer = ObservableField(Player("Somchai", ArrayList<Card>()))
        mSecondPlayer = ObservableField(Player("Somsak", ArrayList<Card>()))
        mStatus = ObservableField("")
        newGame()
    }

    companion object {
        fun create(activity: AppCompatActivity): MainViewModel {
            var productDetailViewModel = ViewModelProviders.of(activity).get(MainViewModel::class.java)
            return productDetailViewModel
        }
    }

    fun onNewGameClick(view: View) {
        newGame()
    }

    fun newGame() {
        if (mDeck.cards.size < 52) mDeck.initDeck()
        mDeck.shuffle()
        dealOutCard()
        mFirstPlayer.get().compute()
        mSecondPlayer.get().compute()
        mStatus.set(when {
            mFirstPlayer.get().mHandType.priority > mSecondPlayer.get().mHandType.priority ||
                    (mFirstPlayer.get().mHandType.priority == mSecondPlayer.get().mHandType.priority &&
                            mFirstPlayer.get().mHighCard.point.value > mSecondPlayer.get().mHighCard.point.value) -> {
                "${mFirstPlayer.get().mName} wins - with ${mFirstPlayer.get().mHandType.toString()}"
            }
            mFirstPlayer.get().mHandType.priority < mSecondPlayer.get().mHandType.priority ||
                    (mFirstPlayer.get().mHandType.priority == mSecondPlayer.get().mHandType.priority &&
                            mFirstPlayer.get().mHighCard.point.value < mSecondPlayer.get().mHighCard.point.value) -> {
                "${mSecondPlayer.get().mName} wins - with ${mSecondPlayer.get().mHandType.toString()}"
            }
            else -> "Tie ${mFirstPlayer.get().mHandType.toString()}"
        })
        mFirstPlayer.notifyChange()
        mSecondPlayer.notifyChange()
    }

    public fun dealOutCard() {
        mFirstPlayer.get().mHand.clear()
        mSecondPlayer.get().mHand.clear()
        // enable this comment to do manual card
//        mFirstPlayer.mHand.add(Card(Card.Suit.C,Card.Value.SIX))
//        mFirstPlayer.mHand.add(Card(Card.Suit.H,Card.Value.TWO))
//        mFirstPlayer.mHand.add(Card(Card.Suit.D,Card.Value.EIGHT))
//        mFirstPlayer.mHand.add(Card(Card.Suit.S,Card.Value.FOUR))
//        mFirstPlayer.mHand.add(Card(Card.Suit.S,Card.Value.FIVE))
//
//        mSecondPlayer.mHand.add(Card(Card.Suit.H,Card.Value.SIX))
//        mSecondPlayer.mHand.add(Card(Card.Suit.C,Card.Value.TWO))
//        mSecondPlayer.mHand.add(Card(Card.Suit.S,Card.Value.EIGHT))
//        mSecondPlayer.mHand.add(Card(Card.Suit.D,Card.Value.FOUR))
//        mSecondPlayer.mHand.add(Card(Card.Suit.D,Card.Value.FIVE))

        // enable auto deal out card
        for(index in 1..5){
            mFirstPlayer.get().mHand.add(mDeck.draw())
            mSecondPlayer.get().mHand.add(mDeck.draw())
        }
    }

    fun bind(databinding: ActivityMainBinding?) {
        mDataBinding = databinding
        mDataBinding?.viewModel = this
    }

    override fun onCleared() {
        super.onCleared()
    }
}