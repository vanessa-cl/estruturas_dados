class CircularStaticList(size: Int) : Listable {
    // uma lista circular estática é uma lista na qual o último elemento aponta para o primeiro
    // formando um loop
    private var startPointer: Int = 0
    private var endPointer: Int = -1
    private var quantity: Int = 0
    private val list: Array<Any?> = arrayOfNulls(size)

    override fun isFull(): Boolean {
        return quantity == list.size
    }

    override fun isEmpty(): Boolean {
        return quantity == 0
    }

    override fun print(): String {
        var result = "["
        val auxPointer = startPointer
        for (i in 0 until quantity) {
            result += if (i == endPointer) {
                "${list[(auxPointer + i) % list.size]}"
            } else {
                "${list[(auxPointer + i) % list.size]}, "
            }
        }
        return "$result]"
    }

    override fun insert(pos: Int, data: Any?) {
        if (!isFull()) {
            // verifica se a posição é válida, para isso ela deve estar entre 0 e a quantidade
            if (pos in 0..<quantity) {

                // ao somar a posição dada pelo usuário com o ponteiro de início, obtemos a posição real dentro dos limites do array
                // a operação de resto da divisão é utilizada para realizar o "giro" que a lista circular faz
                // exemplo: se a lista tem 5 posições e o ponteiro de início está na posição 3, e o usuário deseja inserir um dado na posição 4
                // a posição real será 2, pois 3 + 4 = 7, e 7 % 5 = 2
                var arrayPos = (startPointer + pos) % list.size
                var auxPointer = endPointer + 1

                // o loop abaixo é responsável por deslocar os dados para a direita, para que seja possível inserir o novo dado
                for (i in pos until quantity) {
                    var previous = auxPointer - 1

                    // como a lista é circular, se o ponteiro auxiliar for igual ao tamanho do array
                    // o novo "auxiliar" será a posição 0 para manter a circularidade
                    if (auxPointer == list.size) {
                        auxPointer = 0
                    }
                    var current = auxPointer
                    list[current] = list[previous]
                    auxPointer--
                }
                // inserindo o dado na posição indicada
                list[arrayPos] = data
                endPointer++

                // como a lista é circular, se o ponteiro do final for igual ao tamanho do array
                // o novo "final" será a posição 0 para manter a circularidade
                if (endPointer == list.size) {
                    endPointer = 0
                }
                quantity++
            } else {
                println("Invalid Position!")
            }
        } else {
            println("List is Full!")
        }

    }

    override fun append(data: Any?) {
        if (!isFull()) {
            endPointer++
            // como a lista é circular, se o ponteiro do final for igual ao tamanho do array
            // e ainda assim a lista NÃO está CHEIA, o novo dado será anexado na posição 0
            if (endPointer == list.size) {
                endPointer = 0
            }
            // inserindo o dado na posição do ponteiro de final
            list[endPointer] = data
            quantity++
        } else {
            println("List is Full!")
        }
    }

    override fun select(pos: Int): Any? {
        var auxData: Any? = null
        if (!isEmpty()) {
            // verifica se a posição é válida, para isso ela deve estar entre 0 e a quantidade
            if (pos in 0 until quantity) {
                // ao somar a posição dada pelo usuário com o ponteiro de início, obtemos a posição real dentro dos limites do array
                var arrayPos = (startPointer + pos) % list.size
                // selecionando o dado na posição indicada
                auxData = list[arrayPos]
            } else {
                println("Invalid Position!")
            }
        } else {
            println("List is Empty!")
        }
        return auxData
    }

    override fun selectAll(): Array<Any?> {
        var auxData: Array<Any?> = arrayOfNulls(quantity)
        if (!isEmpty()) {
            var auxPointer = startPointer
            for (i in 0 until quantity) {
                auxData[i] = list[(auxPointer + i) % list.size]
            }
        } else {
            println("List is Empty!")
        }
        return auxData
    }

    override fun update(pos: Int, data: Any?) {
        if (!isEmpty()) {
            // verifica se a posição é válida, para isso ela deve estar entre 0 e a quantidade
            if (pos in 0 until quantity) {
                // ao somar a posição dada pelo usuário com o ponteiro de início, obtemos a posição real dentro dos limites do array
                var arrayPos = (startPointer + pos) % list.size
                // atualizando o dado na posição indicada
                list[arrayPos] = data
            } else {
                println("Invalid Position!")
            }
        } else {
            println("List is Empty!")
        }
    }

    override fun delete(pos: Int): Any? {
        var auxData: Any? = null
        if (!isEmpty()) {
            // verifica se a posição é válida, para isso ela deve estar entre 0 e a quantidade
            if (pos in 0 until quantity) {

                // ao somar a posição dada pelo usuário com o ponteiro de início, obtemos a posição real dentro dos limites do array
                var arrayPos = (startPointer + pos) % list.size
                auxData = list[arrayPos]
                var auxPointer = arrayPos

                for (i in pos until quantity) {
                    var current = auxPointer
                    var next = (auxPointer + 1) % list.size
                    list[current] = list[next]
                    auxPointer++
                }
                // removendo o dado da última posição alterando para null
                list[endPointer] = null
                endPointer--
                // como a lista é circular, se o ponteiro do final for igual a -1
                // o novo "final" será a última posição do array para manter a circularidade
                if (endPointer == -1) {
                    endPointer = list.size - 1
                }
                quantity--
            } else {
                println("Invalid Position!")
            }
        } else {
            println("List is Empty!")
        }
        return auxData
    }

    override fun clear(): Boolean {
        if (!isEmpty()) {
            // substituindo todos os dados da lista por null
            for (i in 0 until quantity) {
                list[i] = null
            }
            // todos os atributos da lista voltam para o estado inicial
            startPointer = 0
            endPointer = -1
            quantity = 0
            return true
        } else {
            println("List is Empty!")
        }
        return false
    }

    // métodos auxiliares para visualização dos ponteiros e quantidade de dados
    fun getStartPointer(): Int {
        return startPointer
    }

    fun getEndPointer(): Int {
        return endPointer
    }

    fun getQuantity(): Int {
        return quantity
    }

    fun getList(): Array<Any?> {
        return list
    }

}
