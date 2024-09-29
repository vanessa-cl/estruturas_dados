class Queue(private val size: Int): Queuable {

    private var data: Array<Any?> = arrayOfNulls(size)
    private var startPointer = 0
    private var endPointer = -1

    init {
        data = arrayOfNulls(size)
    }

    fun getStartPointer(): Int {
        return startPointer
    }

    fun getEndPointer(): Int {
        return endPointer
    }

    fun getData(): Array<Any?> {
        return data
    }

    override fun enqueue(data: Any?) {
        if (!isFull()) {
            endPointer++
            this.data[endPointer] = data
        } else {
            println("Queue is full!")
        }
    }

    override fun front(): Any? {
        var initialData: Any? = null
        if (!isEmpty()) {
            initialData = data[startPointer]
        } else {
            println("Queue is empty!")
        }
        return initialData
    }

    override fun update(data: Any?) {
        if (!isEmpty()) {
            this.data[startPointer] = data
        } else {
            println("Queue is empty!")
        }
    }

    override fun dequeue(): Any? {
        var initialData: Any? = null
        if (!isEmpty()) {
            initialData = data[startPointer]
            startPointer++
        } else {
            println("Queue is empty!")
        }
        return initialData
    }

    override fun isEmpty(): Boolean {
        return (startPointer == endPointer + 1)
    }

    override fun isFull(): Boolean {
        return (endPointer - startPointer + 1) == data.size
    }

    override fun print(): String {
        var result = ""
        for (i in startPointer..endPointer) {
            if (i == endPointer)
                result += "${data[i]}"
            else
                result += "${data[i]},"
        }
        return result
    }
}