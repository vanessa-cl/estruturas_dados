fun main() {
    // Testes da pilha simples/estática
    val s1 = Stack(5)
    println("Pilha vazia? ${s1.isEmpty()}")
    println("Pilha cheia? ${s1.isFull()}")
    println(s1.print())
    s1.push(1)
    s1.push(2)
    s1.push(3)
    s1.push(4)
    s1.push(5)
    println("Pilha vazia? ${s1.isEmpty()}")
    println("Pilha cheia? ${s1.isFull()}")
    println(s1.print())
    println("Dado no topo da pilha: ${s1.peek()}")
    println("Dado retirado do topo da pilha: ${s1.pop()}")
    println("Dado no topo da pilha: ${s1.peek()}")
    println(s1.print())
    println("Pilha cheia? ${s1.isFull()}")
    s1.update(10)
    println(s1.print())

    // Testes da pilha de parênteses em uma expressão
    val p1 = Parentheses()
    println("Parênteses válidos? ${p1.checkValidParentheses("(2*(1+(5*2)))")}") // true
    println("Parênteses válidos? ${p1.checkValidParentheses("(3*(4+2)")}")    // false
}