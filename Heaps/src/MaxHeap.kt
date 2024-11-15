class MaxHeap(private val size: Int = 10): Heaping {
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
            if (heap[parentIndex] < heap[childIndex]) {  // se o pai for menor que o filho
                var temp = heap[parentIndex]            // troca os valores
                heap[parentIndex] = heap[childIndex]
                heap[childIndex] = temp
                childIndex = parentIndex                // atualiza o índice do filho
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

            // verifica se o índice do filho esquerdo for válido (menor que o ponteiro de fim) e o valor do pai é menor que o valor do filho esquerdo
            if (leftChildIndex <= endPointer && heap[biggestIndex] < heap[leftChildIndex]) {
                // então o índice do maior valor é o do filho esquerdo
                biggestIndex = leftChildIndex
            }

            // verifica se o índice do filho direito for válido (menor que o ponteiro de fim) e o valor do pai é menor que o valor do filho direito
            if (rightChildIndex <= endPointer && heap[biggestIndex] < heap[rightChildIndex]) {
                // então o índice do maior valor é o do filho direito
                biggestIndex = rightChildIndex
            }

            // se o índice do menor valor for diferente do índice do pai
            if (biggestIndex != parentIndex) {
                // troca os valores
                var temp = heap[parentIndex]
                heap[parentIndex] = heap[biggestIndex]
                heap[biggestIndex] = temp
                parentIndex = biggestIndex // atualiza o índice do pai
            } else {
                break // se o índice do menor valor for igual ao índice do pai, então o heap está organizado
            }
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
            root = heap[0]              // o maior valor é o primeiro item do heap, que é a raiz
        } else {
            println("Heap is empty!")
        }
        return root
    }

    override fun update(data: Long) {
        if (!isEmpty()) {
            heap[0] = data               // atualiza o valor da raiz
            heapifyDown(0)        // reorganiza o heap a partir do novo valor da raiz
        } else {
            println("Heap is empty!")
        }
    }

    override fun remove(): Long? {
        var root: Long? = null
        if (!isEmpty()) {
            root = heap[0]                  // o maior valor é o primeiro item do heap, que é a raiz
            heap[0] = heap[endPointer]      // troca o item a ser removido pelo último item
            heap[endPointer] = 0            // altera o item a ser removido para 0
            endPointer = endPointer.dec()   // decrementa o ponteiro de fim
            heapifyDown(0)
        } else {
            println("Heap is empty!")
        }
        return root
    }

    override fun print(): String {
        return heap.contentToString()
    }
}