import utils.DoubleNode

class DynamicList(private val size: Int) : Listable {
    private var startPointer: DoubleNode? = null
    private var endPointer: DoubleNode? = null
    private var quantity = 0

    override fun insert(pos: Int, data: Any?) {
        if (!isFull()) {
            // verifica se a posição é válida
            if (pos >= 0 && pos <= quantity) {
                // cria um novo nó para o dado a ser inserido
                val auxNode = DoubleNode(data)
                var previousPointer: DoubleNode? = null
                var nextPointer = startPointer

                // percorre a lista até a posição desejada para inserir o dado
                for (i in 0 until pos) {
                    previousPointer = nextPointer
                    nextPointer = nextPointer?.next
                }

                // insere o dado na posição desejada caso o ponteiro anterior não seja nulo
                if (previousPointer != null) {
                    previousPointer.next = auxNode
                } else {
                    // caso contrário, o dado será inserido no início da lista
                    startPointer = auxNode
                }

                // insere o dado na posição desejada caso o ponteiro seguinte não seja nulo
                if (nextPointer != null) {
                    nextPointer.previous = auxNode
                } else {
                    // caso contrário, o dado será inserido no final da lista
                    endPointer = auxNode
                }

                // ajusta os ponteiros do novo nó e incrementa a quantidade de elementos
                auxNode.previous = previousPointer
                auxNode.next = nextPointer
                quantity++
            } else {
                throw IndexOutOfBoundsException("Posição inválida!")
            }
        } else {
            throw NoSuchElementException("Lista cheia!")
        }
    }

    override fun select(pos: Int): Any? {
        var auxData: Any?
        if (!isEmpty()) {
            // verifica se a posição é válida
            if (pos >= 0 && pos < quantity) {
                // percorre a lista até a posição desejada para selecionar o dado
                var aux = startPointer
                for (i in 0 until pos) {
                    aux = aux?.next
                }
                auxData = aux?.data
            } else {
                throw IndexOutOfBoundsException("Posição inválida")
            }
            // retorna o dado selecionado
            return auxData
        } else {
            throw NoSuchElementException("Lista vazia")
        }
    }

    override fun selectAll(): Array<Any?> {
        var auxData: Array<Any?> = arrayOfNulls(quantity)
        if (!isEmpty()) {
            var auxPointer = startPointer
            // percorre a lista para selecionar todos os dados
            for (i in 0 until quantity) {
                // adiciona o dado selecionado ao array auxiliar
                auxData[i] = auxPointer?.data
                // atualiza o ponteiro para o próximo nó
                auxPointer = auxPointer?.next
            }
        } else {
            throw NoSuchElementException("Lista vazia")
        }
        return auxData
    }

    override fun update(pos: Int, data: Any?) {
        if (!isEmpty()) {
            if (pos >= 0 && pos < quantity) {
                // percorre a lista até a posição desejada para atualizar o dado
                var aux = startPointer
                for (i in 0 until pos) {
                    // atualiza o ponteiro para o próximo nó
                    aux = aux?.next
                }
                // atualiza o dado na posição desejada
                aux?.data = data
            } else {
                throw IndexOutOfBoundsException("Posição inválida")
            }
        } else {
            throw NoSuchElementException("Lista vazia")
        }
    }

    override fun append(data: Any?) {
        if (!isFull()) {
            // cria um novo nó para o dado a ser inserido
            val auxNode = DoubleNode(data);
            // ajusta os ponteiros do novo nó
            auxNode.previous = endPointer
            if (!isEmpty()) {
                // insere o dado no final da lista caso ela não esteja vazia
                endPointer?.next = auxNode
            } else {
                // caso contrário, o dado será inserido no início da lista
                startPointer = auxNode
            }
            // ajusta o ponteiro final para o novo nó e incrementa a quantidade de elementos
            endPointer = auxNode
            quantity++
        } else {
            throw NoSuchElementException("Lista cheia!")
        }
    }

    override fun delete(pos: Int): Any? {
        var auxData: Any? = null
        if (!isEmpty()) {
            if (pos >= 0 && pos < quantity) {
                // percorre a lista até a posição desejada para remover o dado
                var auxPointer = startPointer
                for (i in 0 until pos) {
                    // atualiza o ponteiro para o próximo nó
                    auxPointer = auxPointer?.next
                }
                // armazena o dado a ser removido
                auxData = auxPointer?.data

                // ajusta os ponteiros dos nós adjacentes ao nó a ser removido
                val previousPointer = auxPointer?.previous
                val nextPointer = auxPointer?.next

                if (previousPointer != null) {
                    // caso o ponteiro anterior não seja nulo, ajusta o ponteiro do nó anterior
                    previousPointer.next = nextPointer
                } else {
                    // caso contrário, o dado a ser removido é o primeiro da lista
                    startPointer = startPointer?.next
                }

                if (nextPointer != null) {
                    // caso o ponteiro seguinte não seja nulo, ajusta o ponteiro do nó seguinte
                    nextPointer.previous = previousPointer
                } else {
                    // caso contrário, o dado a ser removido é o último da lista
                    endPointer = endPointer?.previous
                }
                // decrementa a quantidade de elementos
                quantity = quantity.dec()
            } else {
                throw IndexOutOfBoundsException("Posição inválida")
            }
        } else {
            throw NoSuchElementException("Lista vazia")
        }
        return auxData
    }

    override fun clear(): Boolean {
        quantity = 0
        endPointer = null
        startPointer = null
        return true
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

            auxPointer = auxPointer?.previous
        }
        return "$result]"
    }

    // métodos extras para facilitar a visualização dos ponteiros
    fun getStartPointer(): DoubleNode? {
        return startPointer
    }

    fun getEndPointer(): DoubleNode? {
        return endPointer
    }

    fun getQuantity(): Int {
        return quantity
    }
}






