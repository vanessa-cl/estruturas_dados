// Resposta das questões 2 e 3 da prova de 2024.1

class ListaEstaticaCircular(val tamanho: Int = 5) {
    private var dados: Array<Any?> = arrayOfNulls(tamanho)
    private var quantidade = 0
    private var ponteiroInicio = 0
    private var ponteiroFim = -1

    fun estaCheia(): Boolean {
        return quantidade == dados.size
    }

    fun estaVazia(): Boolean {
        return quantidade == 0
    }

    // 0. Inserir um dado no início de uma Lista Estática Circular.
    fun inserirDadoInicio(dado: Any?) {
        if (!estaCheia()) {
            // se o ponteiro de início for menor que 0 ele volta para a última posição do array
            if (ponteiroInicio < 0) {
                ponteiroInicio = dados.size - 1
            }
            // insere o dado na posição do ponteiro de início
            dados[ponteiroInicio] = dado
            // incrementa a quantidade de dados e o ponteiro de fim
            quantidade++
            ponteiroFim++
        } else {
            println("Lista cheia!")
        }
    }

    // 1. Inserir um dado no fim de uma Lista Estática Circular.
    fun inserirDadoFim(dado: Any?) {
        if (!estaCheia()) {
            // se o ponteiro de fim for igual ao tamanho do array ele volta para a posição 0 para manter a circularidade
            if (ponteiroFim == dados.size - 1) {
                ponteiroFim = 0
            }
            ponteiroFim++
            // insere o dado na posição do ponteiro de fim
            dados[ponteiroFim] = dado
            // incrementa a quantidade de dados
            quantidade++
        } else {
            println("Lista cheia!")
        }
    }

    // 2. Inserir um dado numa posição lógica específica de uma Lista Estática Circular.
    fun inserirDado(posicao: Int, dado: Any?) {
        // verifica se não está cheia
        if (!estaCheia()) {
            // verifica se a posição é válida
            if (posicao in 0..quantidade) {
                // obtem a posição física do array
                var posicaoArray = (ponteiroInicio + posicao) % dados.size
                // obtem o ponteiro auxiliar
                var ponteiroAux = ponteiroFim + 1

                // deslocamento dos dados para inserção do item
                for (i in posicao until quantidade) {
                    // obtem a posição anterior ao ponteiro auxiliar
                    var anterior = ponteiroAux - 1

                    // se o ponteiro auxiliar for igual ao tamanho do array ele volta para a posição 0 para manter a circularidade
                    if (ponteiroAux == dados.size) {
                        ponteiroAux = 0
                    }
                    // obtem a posição atual
                    var atual = ponteiroAux
                    // altera o dado da posição atual para o dado da posição anterior
                    dados[atual] = dados[anterior]
                    // decrementa o ponteiro auxiliar
                    ponteiroAux--
                }
                // após o deslocamento insere o dado na posição indicada
                dados[posicaoArray] = dado
                // incrementa o ponteiro final
                ponteiroFim++

                // se o ponteiro final for igual ao tamanho do array ele volta para a posição 0 para manter a circularidade
                if (ponteiroFim == dados.size) {
                    ponteiroFim = 0
                }
                // incrementa a quantidade de dados
                quantidade++
            } else {
                println("Posição inválida!")
            }
        } else {
            println("Lista cheia!")
        }
    }

    // 3. Buscar um dado do início de uma Lista Estática Circular.
    fun buscaDadoInicio(): Any? {
        var dadoAux: Any? = null
        if (!estaVazia()) {
            dadoAux = dados[ponteiroInicio]
        } else {
            println("Lista vazia!")
        }
        return dadoAux
    }

    // 4. Buscar um dado do fim de uma Lista Estática Circular.
    fun buscaDadoFim(): Any? {
        var dadoAux: Any? = null
        if (!estaVazia()) {
            dadoAux = dados[(ponteiroFim - 1) % dados.size]
        } else {
            println("Lista vazia!")
        }
        return dadoAux
    }

    // 5. Buscar um dado de uma posição lógica específica em uma Lista Estática Circular.
    fun buscaDado(posicao: Int): Any? {
        var dadoAux: Any? = null
        if (!estaVazia()) {
            // verifica se a posição é válida
            if (posicao in 0 until quantidade) {
                // obtem a posição física do array
                var posicaoArray = (ponteiroInicio + posicao) % dados.size
                dadoAux = dados[posicaoArray]
            } else {
                println("Posição inválida!")
            }
        } else {
            println("Lista vazia!")
        }
        return dadoAux
    }

    // 6. Buscar todos os dados de uma Lista Estática Circular.
    fun buscaTodosDados(): Array<Any?> {
        var dadosAux: Array<Any?> = arrayOfNulls(quantidade)
        if (!estaVazia()) {
            for (i in 0 until quantidade) {
                var posicaoArray = (ponteiroInicio + i) % dados.size
                dadosAux[i] = dados[posicaoArray]
            }
        } else {
            println("Lista vazia!")
        }
        return dadosAux
    }

    // 7. Verificar a posição lógica da primeira ocorrência de um determinado dado em uma Lista Estática Circular.
    fun verificaPosicaoPrimeiraOcorrencia(dado: Any?): Int? {
        var posicao: Int? = null
        // verifica se a lista não está vazia
        if (!estaVazia()) {
            // percorre a lista de 0 até a quantidade de dados
            for (i in 0 until quantidade) {
                // obtem a posição física do array a cada iteração
                var posicaoArray = (ponteiroInicio + i) % dados.size
                // verifica se o dado da posição encontrada é igual ao dado informado
                if (dados[posicaoArray] == dado) {
                    // se for igual armazena a posição e interrompe o loop
                    posicao = i
                    break
                }
            }
        } else {
            println("Lista vazia!")
        }
        return posicao
    }

    // 8. Verificar a posição lógica da última ocorrência de um determinado dado em uma Lista Estática Circular.
    fun verificaPosicaoUltimaOcorrencia(dado: Any?): Int? {
        var posicao: Int? = null
        // verifica se a lista não está vazia
        if (!estaVazia()) {
            // percorre a lista da (quantidade - 1) até 0
            for (i in (quantidade - 1) downTo 0) {
                // obtem a posição física do array a cada iteração
                // a posição é calculada a partir do ponteiro de fim pois a lista é iterada
                // de trás para frente
                var posicaoArray = ((ponteiroFim + 1) + i) % dados.size
                // verifica se o dado da posição encontrada é igual ao dado informado
                if (dados[posicaoArray] == dado) {
                    // se for igual armazena a posição e interrompe o loop
                    posicao = i
                    break
                }
            }
        } else {
            println("Lista vazia!")
        }
        return posicao
    }

    // 9. Atualizar o dado do início de uma Lista Estática Circular.
    fun atualizarDadoInicio(dado: Any?) {
        if (!estaVazia()) {
            dados[ponteiroInicio] = dado
        } else {
            println("Lista vazia!")
        }
    }

    // 10. Atualizar o dado do fim de uma Lista Estática Circular.
    fun atualizarDadoFim(dado: Any?) {
        if (!estaVazia()) {
            dados[ponteiroFim] = dado
        } else {
            println("Lista vazia!")
        }
    }

    // 11. Atualizar uma posição lógica específica de uma Lista Estática Circular.
    fun atualizarDado(posicao: Int, dado: Any?) {
        if (!estaVazia()) {
            // verifica se a posição é válida
            if (posicao in 0 until quantidade) {
                // obtem a posição física do array
                var posicaoArray = (ponteiroInicio + posicao) % dados.size
                dados[posicaoArray] = dado
            } else {
                println("Posição inválida!")
            }
        } else {
            println("Lista vazia!")
        }
    }

    // 12. Atualizar todos os dados de uma Lista Estática Circular.
    fun atualizarTodosDados(dado: Any?) {
        if (!estaVazia()) {
            for (i in 0 until quantidade) {
                var posicaoArray = (ponteiroInicio + i) % dados.size
                dados[posicaoArray] = dado
            }
        } else {
            println("Lista vazia!")
        }
    }

    // 13. Apagar um dado do início de uma Lista Estática Circular.
    fun apagarDadoInicio(): Any? {
        var dadoAux: Any? = null
        if (!estaVazia()) {
            dadoAux = dados[ponteiroInicio]
            dados[ponteiroInicio] = null
        } else {
            println("Lista vazia!")
        }
        return dadoAux
    }

    // 14. Apagar um dado do fim de uma Lista Estática Circular.
    fun apagarDadoFim(): Any? {
        var dadoAux: Any? = null
        if (!estaVazia()) {
            dadoAux = dados[ponteiroFim]
            dados[ponteiroFim] = null
        } else {
            println("Lista vazia!")
        }
        return dadoAux
    }

    // 15. Apagar um dado de uma posição lógica específica de uma Lista Estática Circular.
    fun apagarDado(posicao: Int): Any? {
        var dadoAux: Any? = null
        if (!estaVazia()) {
            // verifica se a posição é válida
            if (posicao in 0 until quantidade) {
                // obtem a posição física do array
                var posicaoArray = (ponteiroInicio + posicao) % dados.size
                dadoAux = dados[posicaoArray]
                dados[posicaoArray] = null
            } else {
                println("Posição inválida!")
            }
        } else {
            println("Lista vazia!")
        }
        return dadoAux
    }

    // 16. Apagar todos os dados de uma Lista Estática Circular.
    fun apagarTodosDados(): Boolean {
        if (!estaVazia()) {
            for (i in 0 until quantidade) {
                var posicaoArray = (ponteiroInicio + i) % dados.size
                dados[posicaoArray] = null
            }
            return true
        } else {
            println("Lista vazia!")
        }
        return false
    }

    // métodos auxiliares para obter os dados da lista
    fun getDados(): Array<Any?> {
        return dados
    }
}