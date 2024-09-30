// Fila = Queue = FIFO (First In, First Out)
// Enfileiravel = Queuable

class Queue(private val size: Int): Queuable {

    private var queue: Array<Any?> = arrayOfNulls(size)
    private var startPointer = 0
    private var endPointer = -1

    override fun enqueue(data: Any?) {
        if (!isFull()) {
            endPointer++
            queue[endPointer] = data
        } else {
            println("Queue is full!")
        }
    }

    override fun front(): Any? {
        var aux: Any? = null
        if (!isEmpty()) {
            aux = queue[startPointer]
        } else {
            println("Queue is empty!")
        }
        return aux
    }

    override fun update(data: Any?) {
        if (!isEmpty()) {
            queue[startPointer] = data
        } else {
            println("Queue is empty!")
        }
    }

    override fun dequeue(): Any? {
        var aux: Any? = null
        if (!isEmpty()) {
            aux = queue[startPointer]
            queue[startPointer] = null
            startPointer++
        } else {
            println("Queue is empty!")
        }
        return aux
    }

    override fun isEmpty(): Boolean {
        return (startPointer == endPointer + 1)
    }

    override fun isFull(): Boolean {
        return (endPointer - startPointer + 1) == queue.size
    }

    override fun print(): String {
        var result = ""
        for (i in startPointer..endPointer) {
            if (i == endPointer) {
                result += "${queue[i]}"
            }
            else {
                result += "${queue[i]},"
            }

        }
        return result
    }

    // métodos auxiliares para verificação dos ponteiros
    fun getStartPointer(): Int {
        return startPointer
    }

    fun getEndPointer(): Int {
        return endPointer
    }

    fun getData(): Array<Any?> {
        return queue
    }
}