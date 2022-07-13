package com.hegunhee.subwayarrivalinfoapp.Util

import com.hegunhee.subwayarrivalinfoapp.R

val subway_line_limit = arrayOf<String>("1호선","2호선","3호선","4호선","5호선","6호선","7호선","8호선","9호선")

enum class SubwayLineColor(val line : String){
    ONE("1호선"){
        override fun getColor(): Int {
            return R.color.one
        }

    },
    TWO("2호선"){
        override fun getColor(): Int {
            return R.color.two
        }
    },
    THREE("3호선"){
        override fun getColor(): Int {
            return R.color.three
        }
    },
    FOUR("4호선"){
        override fun getColor(): Int {
            return R.color.four
        }

    },
    FIVE("5호선"){
        override fun getColor(): Int {
            return R.color.five
        }
    },
    SIX("6호선"){
        override fun getColor(): Int {
            return R.color.six
        }
    },

    SEVEN("7호선"){
        override fun getColor(): Int {
            return R.color.seven
        }

    },
    EIGHT("8호선"){
        override fun getColor(): Int {
            return R.color.eight
        }
    },
    NINE("9호선"){
        override fun getColor(): Int {
            return  R.color.nine
        }
    };




    abstract fun getColor() : Int
}