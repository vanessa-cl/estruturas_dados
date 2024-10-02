interface Listable {

    // métodos principais
    fun insert(pos: Int, data: Any?)    // C -> insere o dado na posição indicada
    fun append(data: Any?)              // C -> insere o dado no final da lista
    fun select(pos: Int): Any?          // R -> retorna o dado na posição indicada
    fun selectAll(): Array<Any?>        // R -> retorna todos os dados da lista
    fun update(pos: Int, data: Any?)    // U -> atualiza o dado na posição indicada
    fun delete(pos: Int): Any?          // D -> remove o dado na posição indicada
    fun clear(): Boolean                // D -> remove todos os dados da lista

    // métodos auxiliares
    fun print(): String
    fun isEmpty(): Boolean
    fun isFull(): Boolean

    // métodos extras
//    fun inserirInicio()
//    fun selecionarInicio()
//    fun atualizarFim()
}