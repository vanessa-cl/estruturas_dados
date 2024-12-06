import utils.DoubleNode

class DynamicStack(private var size: Int) : Stackable {
    private var topPointer: DoubleNode? = null
    private var quantity = 0

    override fun push(data: Any?) {
        if (!isFull()) {
            // cria um novo nó e atualiza o ponteiro do nó anterior para o nó do topo da pilha
            val auxNode = DoubleNode(data)
            auxNode.previous = topPointer

            if (!isEmpty()) {
                // caso a pilha não esteja vazia, atualiza o ponteiro do próximo nó do topo da pilha
                topPointer?.next = auxNode
            }
            // atualiza o ponteiro do topo da pilha para o novo nó e incrementa a quantidade de elementos
            topPointer = auxNode
            quantity++
        } else {
            throw IndexOutOfBoundsException("Pilha Cheia!")
        }
    }

    override fun pop(): Any? {
        var auxData: Any? = null
        if (!isEmpty()) {
            // obtém o dado do nó do topo da pilha
            auxData = topPointer?.data
            // atualiza o ponteiro do nó anterior do topo da pilha
            topPointer = topPointer?.previous
            quantity--
            if (!isEmpty()) {
                // caso a pilha não esteja vazia, atualiza o ponteiro do próximo nó do topo da pilha
                topPointer?.next = null
            }

        } else {
            throw NoSuchElementException("Pilha Vazia!")
        }
        return auxData
    }

    override fun peek(): Any? {
        var auxData: Any? = null
        if (!isEmpty()) {
            // obtém o dado do nó do topo da pilha
            auxData = topPointer?.data
        } else {
            throw NoSuchElementException("Pilha Vazia!")
        }
        return auxData
    }

    override fun update(data: Any?) {
        if (!isEmpty())
            topPointer?.data = data
        else
            throw NoSuchElementException("Pilha Vazia!")
    }

    override fun isFull(): Boolean {
        return quantity == size
    }

    override fun isEmpty(): Boolean {
        return quantity == 0
    }

    override fun print(): String {
        var auxPointer = topPointer
        var result = "["
        for (i in 0 until quantity) {
            result += auxPointer?.data
            if (i != quantity - 1)
                result += ",\n"

            auxPointer = auxPointer?.previous
        }
        return "$result]"
    }

    fun getTopPointer(): DoubleNode? {
        return topPointer
    }
}