import utils.DoubleNode

class DynamicQueue(private val size: Int) : Queuable {
    private var startPointer: DoubleNode? = null
    private var endPointer: DoubleNode? = null
    private var quantity = 0

    override fun enqueue(data: Any?) {
        if (!isFull()) {
            val auxNode = DoubleNode(data)
            auxNode.previous = endPointer
            if (!isEmpty()) {
                // caso a fila não esteja vazia, o próximo nó do ponteiro final deve ser o novo nó
                endPointer?.next = auxNode
            } else {
                // caso contrário, o ponteiro de início deve ser o novo nó
                startPointer = auxNode
            }
            // atualiza o ponteiro final para o novo nó e incrementa a quantidade de elementos
            endPointer = auxNode
            quantity = quantity.inc()
        } else {
            throw IndexOutOfBoundsException("Fila cheia")
        }
    }

    override fun dequeue(): Any? {
        var auxData: Any? = null
        if (!isEmpty()) {
            // guarda o dado a ser removido
            auxData = startPointer?.data
            // atualiza o ponteiro de início para o próximo nó e decrementa a quantidade de elementos
            startPointer = startPointer?.next
            quantity = quantity.dec()
            if (!isFull()) {
                // caso a fila não esteja cheia, o ponteiro anterior do novo início deve ser nulo
                startPointer?.previous = null
            } else {
                // caso contrário, o ponteiro final deve ser nulo
                endPointer = null
            }
        } else {
            throw NoSuchElementException("Fila vazia")
        }
        return auxData
    }

    override fun front(): Any? {
        var auxData: Any? = null
        if (!isEmpty()) {
            auxData = startPointer?.data
        } else {
            throw NoSuchElementException("Fila vazia")
        }
        return auxData
    }

    override fun update(data: Any?) {
        if (!isEmpty()) {
            startPointer?.data = data
        } else {
            throw NoSuchElementException("Fila vazia")
        }
    }

    override fun isFull(): Boolean {
        return quantity == size
    }

    override fun isEmpty(): Boolean {
        return quantity == 0
    }

    override fun print(): String {
        var auxPointer = startPointer
        var result = "["
        for (i in 0 until quantity) {
            result += auxPointer?.data
            if (i != quantity - 1)
                result += ","

            auxPointer = auxPointer?.next
        }
        return "$result]"
    }
}