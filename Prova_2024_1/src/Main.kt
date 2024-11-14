import getQuestoesProva

// Exemplo de uso:
// var arrayQuestoes = getQuestoesProva("202321190050")
// println(arrayQuestoes.contentToString())

fun main() {
    // Testes dos métodos da classe ListaEstaticaCircular
    val l1 = ListaEstaticaCircular()

    // 2.
    l1.inserirDado(0, "B")
    println("Array após alterações: ${l1.getDados().contentToString()}")
    println("___________________________")

    l1.inserirDado(1, "C")
    println("Array após alterações: ${l1.getDados().contentToString()}")
    println("___________________________")

    l1.inserirDado(2, "D")
    println("Array após alterações: ${l1.getDados().contentToString()}")
    println("___________________________")

    l1.inserirDado(3, "E")
    println("Array após alterações: ${l1.getDados().contentToString()}")
    println("___________________________")

    l1.inserirDado(4, "F")
    println("Array após alterações: ${l1.getDados().contentToString()}")
    println("___________________________")

    l1.inserirDado(4, "A")
    println("Array após alterações: ${l1.getDados().contentToString()}")
    println("___________________________")

    // 0.
//    l1.inserirDadoInicio("A");
//    println("Array após alterações: ${l1.getDados().contentToString()}")
//    println("___________________________")
//
    // 1.
//    l1.inserirDadoFim("F")
//    println("Array após alterações: ${l1.getDados().contentToString()}")
//    println("___________________________")

    // 3.
//    println("Dado do início: ${l1.buscaDadoInicio()}")
//
//    // 4.
//    println("Dado do fim: ${l1.buscaDadoFim()}")
//
//    // 5.
//    println("Dado da posição 2: ${l1.buscaDado(2)}")
//
//    // 6.
//    println("Todos os Dados: ${l1.buscaTodosDados().contentToString()}")

    // 7.
//    println("Primeira ocorrência: ${l1.verificaPosicaoPrimeiraOcorrencia("D")}")

    // 8.
//    println("Última ocorrência: ${l1.verificaPosicaoUltimaOcorrencia("D")}")

    // 9.
//    l1.atualizarDadoInicio("A")
//    println("Array após alterações: ${l1.getDados().contentToString()}")
//    println("___________________________")
//
//    // 10.
//    l1.atualizarDadoFim("G")
//    println("Array após alterações: ${l1.getDados().contentToString()}")
//    println("___________________________")
//
//    // 11.
//    l1.atualizarDado(3, "X")
//    println("Array após alterações: ${l1.getDados().contentToString()}")
//    println("___________________________")
//
//    // 12.
//    l1.atualizarTodosDados("Z")
//    println("Array após alterações: ${l1.getDados().contentToString()}")
//    println("___________________________")

    // 13.
//    println("Dado apagado: ${l1.apagarDadoInicio()}")
//    println("Array após alterações: ${l1.getDados().contentToString()}")
//    println("___________________________")
//
//    // 14.
//    println("Dado apagado: ${l1.apagarDadoFim()}")
//    println("Array após alterações: ${l1.getDados().contentToString()}")
//    println("___________________________")
//
//    // 15.
//    println("Dado apagado: ${l1.apagarDado(2)}")
//    println("Array após alterações: ${l1.getDados().contentToString()}")
//    println("___________________________")
//
//    // 16.
//    println("Dado apagado: ${l1.apagarTodosDados()}")
//    println("Array após alterações: ${l1.getDados().contentToString()}")
//    println("___________________________")


}