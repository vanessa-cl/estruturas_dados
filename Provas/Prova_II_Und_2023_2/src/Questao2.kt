//Implemente o método “inserirComeco(dado: Any)” de uma Lista Dinâmica
//Duplamente Encadeada que sempre insere um novo dado no início da Estrutura de Dados.

interface Listavel {
    // implementei somente os métodos abaixo, pois são os únicos necessários para a questão
    fun inserirComeco(dado: Any)
    fun estaCheia(): Boolean
    fun estaVazia(): Boolean
    fun imprimir(): String
//    fun inserir(posicao: Int, dado: Any)
//    fun anexar(dado: Any)
//    fun selecionar(posicao: Int): Any
//    fun selecionarTodos(): Array<Any>
//    fun atualizar(posicao: Int, dado: Any)
//    fun deletar(posicao: Int): Any
}

data class NoDuplo(var dado: Any) {
    var proximo: NoDuplo? = null
    var anterior: NoDuplo? = null
}

class ListaDinamica(private var tamanho: Int = 10) : Listavel {
    private var ponteiroInicio: NoDuplo? = null
    private var ponteiroFim: NoDuplo? = null
    private var quantidade = 0

    override fun inserirComeco(dado: Any) {
        var novoNo = NoDuplo(dado)
        if (!estaCheia()) {
            if (estaVazia()) {
                // se a lista está vazia, o ponteiro de início e de fim apontam para o novo nó
                ponteiroFim = novoNo
            } else {
                // se a lista não está vazia, o novo nó terá como próximo o atual ponteiro de início
                novoNo.proximo = ponteiroInicio
                // enquanto o atual ponteiro de início terá o novo nó como anterior
                ponteiroInicio?.anterior = novoNo
            }
            // o ponteiro de início aponta para o novo nó e incrementa a quantidade
            ponteiroInicio = novoNo
            quantidade++
        } else {
            throw IndexOutOfBoundsException("A lista está cheia!")
        }
    }

    override fun estaCheia(): Boolean {
        return quantidade == tamanho
    }

    override fun estaVazia(): Boolean {
        return quantidade == 0
    }

    override fun imprimir(): String {
        var resultado = "["
        var noAtual = ponteiroInicio
        for (i in 0 until quantidade) {
            if (i == quantidade - 1) {
                resultado += "${noAtual?.dado}"
            } else {
                resultado += "${noAtual?.dado}, "
            }
            noAtual = noAtual?.proximo
        }
        return "$resultado]"
    }
}