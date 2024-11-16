package systemProcess.collections

import Heaping
import systemProcess.entities.SystemProcess

class SystemProcessHeap(private val size: Int) : Heaping<SystemProcess> {
    private var heap = Array<SystemProcess?>(size) { null }
    private var endPointer = -1

    override fun insert(data: SystemProcess) {
        if (!isFull()) {
            endPointer = endPointer.inc()
            heap[endPointer] = data
            heapifyUp(endPointer)
        } else {
            println("Heap is full!")
        }
    }

    private fun heapifyUp(index: Int) {
        var childIndex = index

        while (childIndex != 0) {
            val parentIndex = parentIndex(childIndex)
            if ((heap[parentIndex]?.priority ?: 0) < (heap[childIndex]?.priority ?: 0)) {
                var temp = heap[parentIndex]
                heap[parentIndex] = heap[childIndex]
                heap[childIndex] = temp
                childIndex = parentIndex
            } else {
                break
            }
        }
    }

    private fun heapifyDown(index: Int) {
        var parentIndex = index

        while (true) {
            var leftChildIndex = leftChildIndex(parentIndex)
            var rightChildIndex = rightChildIndex(parentIndex)
            var biggestIndex = parentIndex

            if (leftChildIndex <= endPointer && (heap[biggestIndex]?.priority ?: 0) < (heap[leftChildIndex]?.priority
                    ?: 0)
            ) {
                biggestIndex = leftChildIndex
            }

            if (rightChildIndex <= endPointer && (heap[biggestIndex]?.priority ?: 0) < (heap[rightChildIndex]?.priority
                    ?: 0)
            ) {
                biggestIndex = rightChildIndex
            }

            if (biggestIndex != parentIndex) {
                var temp = heap[parentIndex]
                heap[parentIndex] = heap[biggestIndex]
                heap[biggestIndex] = temp
                parentIndex = biggestIndex
            } else {
                break
            }
        }
    }

    override fun remove(): SystemProcess? {
        var root: SystemProcess? = null
        if (!isEmpty()) {
            root = heap[0]
            heap[0] = heap[endPointer]
            heap[endPointer] = null
            endPointer = endPointer.dec()
            heapifyDown(0)
        } else {
            println("Heap is empty!")
        }
        return root
    }

    override fun get(): SystemProcess? {
        var root: SystemProcess? = null
        if (!isEmpty()) {
            root = heap[0]
        } else {
            println("Heap is empty!")
        }
        return root
    }

    override fun update(data: SystemProcess) {
        if (!isEmpty()) {
            heap[0] = data
            heapifyDown(0)
        } else {
            println("Heap is empty!")
        }
    }

    override fun isFull(): Boolean {
        return endPointer == size - 1
    }

    override fun isEmpty(): Boolean {
        return endPointer == -1
    }

    fun printProcesses() {
        heap.forEach {
            println("___________________________________________________________________________________")
            println(it.toString())
        }
    }

    override fun print(): String {
        var result = "["
        for (i in 0..endPointer) {
            result += "Process ${heap[i]?.name} with priority ${heap[i]?.priority}"
            if (i != endPointer)
                result += ", "
        }
        return "$result]"
    }

    private fun parentIndex(childIndex: Int): Int {
        return (childIndex - 1) / 2          // o índice do pai é dado pela fórmula (i - 1) / 2
    }

    private fun leftChildIndex(parentIndex: Int): Int {
        return (2 * parentIndex) + 1         // o índice do filho esquerdo é dado pela fórmula 2*i
    }

    private fun rightChildIndex(parentIndex: Int): Int {
        return (2 * parentIndex + 1) + 1     // o índice do filho direito é dado pela fórmula 2*i + 1
    }
}