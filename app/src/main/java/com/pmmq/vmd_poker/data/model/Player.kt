package com.pmmq.vmd_poker.data.model

import java.util.*
import kotlin.collections.HashMap

/**
 * Created by pmmq on 2/6/2018.
 */
class Player(name: String, hand: ArrayList<Card>) {

    var mName = name
    var mHand: ArrayList<Card> = hand
    var mScore: Int = 0
    lateinit var mHighCard: Card
    lateinit var mHandType: HandType

    fun compute() {
        val valueCounter = HashMap<Card.Value, Int>()
        val suitCounter = HashMap<Card.Suit, Int>()
        for (card in mHand) {
            var pointCount = 1
            var suitCount = 1
            // count point
            if (valueCounter.containsKey(card.point)) pointCount = valueCounter.get(card.point)?.plus(1) as Int
            valueCounter.put(card.point, pointCount ?: 1)
            // count suit
            if (suitCounter.containsKey(card.suit)) suitCount = suitCounter.get(card.suit)?.plus(1) as Int
            suitCounter.put(card.suit, suitCount ?: 1)
            print(" ${card.point.value}")
        }
        mHighCard = mHand.maxBy { card: Card -> card.point.value } as Card
        println("")

        val faceGroup = valueCounter.size
        val suitGroup = suitCounter.size
        val max: Int? = valueCounter.maxBy { (_, value) -> value }?.value ?: 1
        when (faceGroup) {
            4 -> mHandType = HandType.ONE_PAIR
            3 -> {
                if (max == 3) {
                    mHandType = HandType.TREE_CARD
                } else {
                    mHandType = HandType.TWO_PAIR
                }
            }
            2 -> {
                if (max == 4) {
                    mHandType = HandType.FOUR_CARD
                } else {
                    mHandType = HandType.FULL_HOUSE
                }
            }
            else -> {
                val isStraight = if (suitGroup == 1) true else false
                val isFlush = isFlush()
                if (isStraight && isFlush) {
                    mHandType = HandType.STRAIGHT_FLUSH
                } else if (isStraight) {
                    mHandType = HandType.STRAIGHT
                } else if (isFlush) {
                    mHandType = HandType.FLUSH
                } else {
                    mHandType = HandType.HIGH_SCORE
                }
            }
        }
    }

    private fun isFlush(): Boolean {
        val valueSorted = mHand.sortedBy { it.point.value }
        mHighCard = valueSorted[4]
        if (valueSorted[0].point.value + 4 == valueSorted[4].point.value ||
                valueSorted[4].point.value == 14 && valueSorted[0].point.value == 2 && valueSorted[3].point.value == 5) {
            return true
        }
        return false
    }

    public enum class HandType(val priority: Int) {
        HIGH_SCORE(0),
        ONE_PAIR(1),
        TWO_PAIR(2),
        TREE_CARD(3),
        FOUR_CARD(7),
        FULL_HOUSE(6),
        STRAIGHT(4),
        FLUSH(5),
        STRAIGHT_FLUSH(8),
    }
}