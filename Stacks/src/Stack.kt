// Pilha = Stack = LIFO = Last In, First Out
// Empilhavel

class Stack(private val size: Int): Stackable {
    // variaveis de instância/globais
    private var stack: Array<Any?> = arrayOfNulls(size)     // array que vai conter os dados
    private var topPointer: Int = -1                        // variavel inteira que contem a referência para o topo da pilha

    // implementação dos métodos auxiliares

    override fun isEmpty(): Boolean {   // override indica que a função está sobrescrevendo uma função da interface
        return (topPointer == -1)       // expressão lógica que tem como resultado true ou false
    }

    override fun isFull(): Boolean {
        return (topPointer == stack.size - 1)
    }

    override fun print(): String {
        var result = "["
        for (i in 0 until stack.size) {
            result += "${stack[i]}"
            if (i < stack.size - 1) {
                result += ","
            }
        }
        return "$result]"
    }

    // implementação dos métodos principais

    override fun push(data: Any?) {
        // se a pilha não estiver cheia, topPointer é incrementado e o dado é inserido na pilha
        // se a pilha estiver cheia, é retornada uma mensagem de erro
        if (!isFull()) {
            topPointer++
            stack[topPointer] = data
        } else {
            println("Stack is full!")
        }
    }

    override fun peek(): Any? {
        // se a pilha não estiver vazia, o dado do topo da pilha é retornado, caso contrário é retornada uma mensagem de erro
        return if (!isEmpty()) {
            stack[topPointer]
        } else {
            println("Stack is empty!")
            null
        }

    }

    override fun update(data: Any?) {
        // se a pilha não estiver vazia, o dado do topo da pilha é atualizado, caso contrário é retornada uma mensagem de erro
        if (!isEmpty()) {
            stack[topPointer] = data
        } else {
            println("Stack is empty!")
        }
    }

    override fun pop(): Any? {
        // se a pilha não estiver vazia, o dado do topo da pilha é removido e retornado na variável aux, caso contrário é retornada uma mensagem de erro
        var aux: Any? = null
        if (!isEmpty()) {
            aux = stack[topPointer]
            // ao remover o item da pilha, o topo da pilha recebe o valor null e o topPointer é decrementado
            stack[topPointer] = null
            topPointer--

        } else {
            println("Stack is empty!")
        }
        return aux
    }

    // métodos auxiliares para verificação dos pointeiros
    fun getTopPointer(): Int {
        return topPointer
    }

    fun getStack(): Array<Any?> {
        return stack
    }
}