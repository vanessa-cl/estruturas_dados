class ReversedStack(size: Int) : Stackable {
    // variaveis de instância/globais
//    private var stack: Array<Any?>
//    private var topPointer: Int?
//
//    init {
//        stack = arrayOfNulls(size)
//        topPointer = stack.size - 1
//    }
//
//    // implementação dos métodos auxiliares
//
//    override fun isEmpty(): Boolean {
//        return (topPointer == stack.size - 1)
//    }
//
//    override fun isFull(): Boolean {
//        return (topPointer == 0)
//    }
//
//    override fun print(): String {
//        var result = "["
//        for (i in topPointer!!..stack.size - 1) {
//            println("i: $i")
//            if (i != 0) {
//                result += ", ${stack[i]}"
//            } else {
//                result += "${stack[i]}"
//            }
//            println("result: $result")
//        }
//        return "$result]"
//    }
//
//    // implementação dos métodos principais
//
//    override fun push(data: Any?) {
//        // se a pilha não estiver cheia, topPointer é incrementado e o dado é inserido na pilha
//        // se a pilha estiver cheia, é retornada uma mensagem de erro
//        if (!isFull()) {
//            topPointer = topPointer?.minus(1)   // ?. indica que a variável pode ser nula
//            stack[topPointer!!] =
//                data              // !! indica que a variável não é nula quando usada como índice do array
//        } else {
//            println("Stack is full!")
//        }
//    }
//
//    override fun peek(): Any? {
//        // se a pilha não estiver vazia, o dado do topo da pilha é retornado, caso contrário é retornada uma mensagem de erro
//        return if (!isEmpty()) {
//            stack[topPointer!!]
//        } else {
//            println("Stack is empty!")
//            null
//        }
//
//    }
//
//    override fun update(data: Any?) {
//        // se a pilha não estiver vazia, o dado do topo da pilha é atualizado, caso contrário é retornada uma mensagem de erro
//        if (!isEmpty()) {
//            stack[topPointer!!] = data
//        } else {
//            println("Stack is empty!")
//        }
//    }
//
//    override fun pop(): Any? {
//        // se a pilha não estiver vazia, o dado do topo da pilha é removido e retornado na variável aux, caso contrário é retornada uma mensagem de erro
//        var aux: Any? = null
//        if (!isEmpty()) {
//            aux = stack[topPointer!!]
//            // ao remover o item da pilha, o topo da pilha recebe o valor null e o topPointer é decrementado
//            stack[topPointer!!] = null
//            topPointer = topPointer?.minus(1)
//
//        } else {
//            println("Stack is empty!")
//        }
//        return aux
//    }
}