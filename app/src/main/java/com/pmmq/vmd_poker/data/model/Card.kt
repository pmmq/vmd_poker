package com.pmmq.vmd_poker.data.model

class Card(suit: Suit, value: Value) {

    val suit:Suit = suit
    val point:Value = value

    public enum class Suit(val value: Int) {
        C(4), D(3), H(2), S(1)
    }

    public enum class Value(val value: Int) {
        TWO(2), TREE(3), FOUR(4), FIVE(5), SIX(6),
        SEVEN(7), EIGHT(8), NINE(9), TEN(10), JACK(11),
        QUEEN(12), KING(13), ACE(14)
    }

    public fun getCardName() : String{
        return "${point.toString()} of ${suit.toString()}"
    }

}