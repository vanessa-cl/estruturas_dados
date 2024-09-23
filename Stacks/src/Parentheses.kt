class Parentheses: Stackable {
    // a pilha de parênteses é implementada com uma pilha simples/estática que utiliza os métodos da interface Stackable para as operações
    private val stack = Stack(10)

    override fun isEmpty(): Boolean {
        return stack.isEmpty()
    }

    override fun isFull(): Boolean {
        return stack.isFull()
    }

    override fun print(): String {
        return stack.print()
    }

    override fun push(data: Any?) {
        stack.push(data)
    }

    override fun peek(): Any? {
        return stack.peek()
    }

    override fun update(data: Any?) {
        stack.update(data)
    }

    override fun pop(): Any? {
        return stack.pop()
    }

    fun checkValidParentheses(expression: String): Boolean {
        // para cada caractere na expressão é verificado se é um parêntese de abertura ou fechamento
        for (char in expression) {
            // se for um parêntese de abertura, é inserido na pilha
            if (char == '(') {
                push(char)
            } else if (char == ')') {
                // se for um parêntese de fechamento, é verificado se a pilha está vazia
                if (isEmpty()) {
                    return false
                }
                // se a pilha não estiver vazia, o parêntese de abertura correspondente é retirado da pilha
                pop()
            }
        }
        return isEmpty()
    }
}