package com.example.kendigenericlistem

class MyCollectionKT<T>(initialCapacity: Int = 10) {
    private var position = 0
    private var capacity = initialCapacity
    private var elements: Array<Any?> = arrayOfNulls<Any>(capacity)

    val size: Int
        get() = position

    val isEmpty: Boolean
        get() = position == 0

    fun addData(data: T) {
        if (position >= capacity) {
            capacity *= 2
            elements = elements.copyOf(capacity)
        }
        elements[position] = data
        position++
    }

    fun get(index: Int): T? {
        return if (index in 0 until position) {
            elements[index] as T
        } else {
            null
        }
    }

    fun remove(index: Int): Array<Any?>? {
        if (index < 0 || index >= position) {
            return null
        }
        val removedElement = elements[index]
        for (i in index until position - 1) {
            elements[i] = elements[i + 1]
        }
        elements[position - 1] = null // Son elemanı null yap
        position--
        return elements
    }

    fun set(index: Int, data: T) {
        if (index in 0 until position) {
            elements[index] = data
        }
    }

    fun indexOf(data: T): Int {
        for (i in 0 until position) {
            if (elements[i] == data) {
                return i
            }
        }
        return -1
    }

    fun lastIndexOf(data: T): Int {
        for (i in position - 1 downTo 0) {
            if (elements[i] == data) {
                return i
            }
        }
        return -1
    }

    fun toArray(): Array<T?> {
        return elements.copyOf(position) as Array<T?>
    }

    fun clear() {
        for (i in 0 until position) {
            elements[i] = null
        }
        position = 0
        capacity = 10
        elements = arrayOfNulls(capacity)
    }

    fun sublist(start: Int, finish: Int): MyCollection<T> {
        if (start < 0 || finish > position || start > finish) {
            throw IndexOutOfBoundsException("Geçersiz indeks aralığı")
        }

        val subList = MyCollection<T>(finish - start)
        for (i in start until finish) {
            subList.addData(elements[i] as T)
        }
        return subList
    }

    fun contains(data: T): Boolean {
        for (i in 0 until position) {
            if (elements[i] == data) {
                return true
            }
        }
        return false
    }

    override fun toString(): String {
        return "MyCollection(size=$position, capacity=$capacity, elements=${elements.joinToString()})"
    }
}