fun main() {
    // Testes da fila estática

    val q1 = Queue(5)
    println("Fila vazia? ${q1.isEmpty()}")
    println("___________________________")
    println("Fila cheia? ${q1.isFull()}")
    println("___________________________")

    // conforme vamos adicionando os itens na fila, o ponteiro do final vai aumentando
    println("Adicionando dados na fila: ")
    q1.enqueue("A")
    println("startPointer: ${q1.getStartPointer()}")
    println("endPointer: ${q1.getEndPointer()}")
    println("___________________________")
    q1.enqueue("B")
    println("startPointer: ${q1.getStartPointer()}")
    println("endPointer: ${q1.getEndPointer()}")
    println("___________________________")
    q1.enqueue("C")
    println("startPointer: ${q1.getStartPointer()}")
    println("endPointer: ${q1.getEndPointer()}")
    println("___________________________")
    q1.enqueue("D")
    println("startPointer: ${q1.getStartPointer()}")
    println("endPointer: ${q1.getEndPointer()}")
    println("___________________________")
    q1.enqueue("E")
    println("startPointer: ${q1.getStartPointer()}")
    println("endPointer: ${q1.getEndPointer()}")
    println("___________________________")
    q1.enqueue("F")
    println("startPointer: ${q1.getStartPointer()}")
    println("endPointer: ${q1.getEndPointer()}")
    println("___________________________")
    println("Imprimindo os dados da fila: ")
    println(q1.print())
    println("Visualizando o array após as operações: ")
    println(q1.getData().contentToString())

    println("___________________________")
    println("Fila vazia? ${q1.isEmpty()}")
    println("___________________________")
    println("Fila cheia? ${q1.isFull()}")
    println("___________________________")

    println("Removendo dados da fila: ")
    // conforme vamos removendo os itens da fila, o ponteiro do inicio vai aumentando
    println("Dado no inicio da fila: ${q1.front()}")
    println("___________________________")
    println("Dado retirado do inicio da fila: ${q1.dequeue()}")
    println("startPointer: ${q1.getStartPointer()}")
    println("endPointer: ${q1.getEndPointer()}")
    println("___________________________")
    println("Dado no inicio da fila: ${q1.front()}")
    println("___________________________")
    println("Imprimindo os dados da fila: ")
    println(q1.print())
    println("Visualizando o array após as operações: ") // o dado A não foi removido da fila, apenas o ponteiro de inicio foi alterado
    println(q1.getData().contentToString())


    println("___________________________")
    println("Fila cheia? ${q1.isFull()}")
    println("Fila vazia? ${q1.isEmpty()}")
    println("___________________________")

    println("Atualizando o dado no inicio da fila: ")
    q1.update("F")
    println("startPointer: ${q1.getStartPointer()}")
    println("endPointer: ${q1.getEndPointer()}")
    println("___________________________")
    println(q1.print())
    println("___________________________")

    // como os dados não são devidamente removidos da fila, o código abaixo não irá funcionar pois o array não possui mais espaços vazios
    q1.enqueue("G")
    println("startPointer: ${q1.getStartPointer()}")
    println("endPointer: ${q1.getEndPointer()}")
    println("___________________________")
}