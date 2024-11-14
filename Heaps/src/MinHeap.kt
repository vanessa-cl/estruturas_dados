class MinHeap(private val size: Int = 10) : Heaping {

    private var heap = LongArray(size) { 0 }   // cria um array de longs com o tamanho especificado
    private var endPointer = -1                // e inicializa todos os valores com 0

    override fun insert(data: Long) {
        if (!isFull()) {
            endPointer = endPointer.inc()   // incrementa o ponteiro de fim
            heap[endPointer] = data         // insere o dado na posição do ponteiro de fim
            heapifyUp(endPointer)           // chama o método para reorganizar o heap
        } else {
            println("Heap is full!")
        }
    }

    private fun heapifyUp(index: Int) {
        var childIndex = index

        while (childIndex != 0) {
            val parentIndex = parentIndex(childIndex)
            if (heap[parentIndex] > heap[childIndex]) {  // se o pai for maior que o filho
                var temp = heap[parentIndex]            // troca os valores
                heap[parentIndex] = heap[childIndex]
                heap[childIndex] = temp
            } else {
                break
            }
        }
    }

    private fun recursiveHeapifyUp(index: Int) {
        if (index == 0) return
        val parentIndex = parentIndex(index)
        if (heap[parentIndex] > heap[index]) {
            var temp = heap[parentIndex]
            heap[parentIndex] = heap[index]
            heap[index] = temp
            recursiveHeapifyUp(parentIndex)
        }
    }

    private fun heapifyDown(index: Int) {
        var parentIndex = index

        while (true) {
            var leftChildIndex = leftChildIndex(parentIndex)
            var rightChildIndex = rightChildIndex(parentIndex)
            var smallestIndex = parentIndex

            // verifica se o índice do filho esquerdo for válido (menor que o ponteiro de fim) e o valor do filho esquerdo for menor que o valor do pai
            if (leftChildIndex <= endPointer && heap[leftChildIndex] < heap[smallestIndex]) {
                // então o índice do menor valor é o do filho esquerdo
                smallestIndex = leftChildIndex
            }

            // verifica se o índice do filho direito for válido (menor que o ponteiro de fim) e o valor do filho direito for menor que o valor do pai
            if (rightChildIndex <= endPointer && heap[rightChildIndex] < heap[smallestIndex]) {
                // então o índice do menor valor é o do filho direito
                smallestIndex = rightChildIndex
            }

            // se o índice do menor valor for diferente do índice do pai
            if (smallestIndex != parentIndex) {
                // troca os valores
                var temp = heap[parentIndex]
                heap[parentIndex] = heap[smallestIndex]
                heap[smallestIndex] = temp
                parentIndex = smallestIndex
            } else {
                break // se o índice do menor valor for igual ao índice do pai, então o heap está organizado
            }
        }
    }

    private fun recursiveHeapifyDown(index: Int) {
        var parentIndex = index
        var leftChildIndex = leftChildIndex(parentIndex)
        var rightChildIndex = rightChildIndex(parentIndex)
        var smallestIndex = parentIndex

        // verifica se o índice do filho esquerdo for válido (menor que o ponteiro de fim) e o valor do filho esquerdo for menor que o valor do pai
        if (leftChildIndex <= endPointer && heap[leftChildIndex] < heap[smallestIndex]) {
            // então o índice do menor valor é o do filho esquerdo
            smallestIndex = leftChildIndex
        }

        // verifica se o índice do filho direito for válido (menor que o ponteiro de fim) e o valor do filho direito for menor que o valor do pai
        if (rightChildIndex <= endPointer && heap[rightChildIndex] < heap[smallestIndex]) {
            // então o índice do menor valor é o do filho direito
            smallestIndex = rightChildIndex
        }

        // se o índice do menor valor for diferente do índice do pai
        if (smallestIndex != parentIndex) {
            // troca os valores
            var temp = heap[parentIndex]
            heap[parentIndex] = heap[smallestIndex]
            heap[smallestIndex] = temp
            recursiveHeapifyDown(smallestIndex)
        }
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

    override fun isEmpty(): Boolean {
        return endPointer == -1
    }

    override fun isFull(): Boolean {
        return endPointer == size - 1
    }

    override fun get(): Long? {
        var root: Long? = null
        if (!isEmpty()) {
            root = heap[0]
            return root
        } else {
            println("Heap is empty!")
            return root
        }
    }

    override fun update(data: Long) {
        if (!isEmpty()) {
            heap[0] = data
            heapifyDown(0)
        } else {
            println("Heap is empty!")
        }
    }

    override fun remove(): Long? {
        var root: Long? = null
        if (!isEmpty()) {
            root = heap[0]
            heap[0] = heap[endPointer]
            endPointer = endPointer.dec()   // decrementa o ponteiro de fim
            heapifyDown(0)
            return root
        } else {
            println("Heap is empty!")
            return root
        }
    }

    override fun print(): String {
        return heap.contentToString()
    }
}