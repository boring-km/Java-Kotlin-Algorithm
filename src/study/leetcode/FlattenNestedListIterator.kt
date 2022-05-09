package study.leetcode

// https://leetcode.com/problems/flatten-nested-list-iterator/

class NestedInteger {

    private var number: Int? = null
    private var numberList = arrayListOf<NestedInteger>()

    constructor()
    constructor(value: Int)

    fun isInteger(): Boolean {
        return number != null
    }

    fun getInteger(): Int? {
        return number
    }

    fun setInteger(value: Int): Unit {
        number = value
    }

    fun add(ni: NestedInteger): Unit {
        number = null
        numberList.add(ni)
    }

    fun getList(): List<NestedInteger>? {
        return numberList
    }
}

class FlattenNestedListIterator(var nestedList: List<NestedInteger>) {
    var index = 0
    var answerList = arrayListOf<Int>()
    init {
        for (nested in nestedList) {
            recursive(nested)
        }
    }

    private fun recursive(nested: NestedInteger) {
        if (nested.isInteger()) answerList.add(nested.getInteger()!!)
        else {
            for (another in nested.getList()!!) {
                recursive(another)
            }
        }
    }

    fun next(): Int {
        return answerList[index++]
    }

    fun hasNext(): Boolean {
        return index < answerList.size
    }
}