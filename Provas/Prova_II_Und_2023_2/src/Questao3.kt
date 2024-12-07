// Implemente um método “boolean ehPalindromo(String data)” para verificação de
// palíndromos utilizando Pilha Dinâmica.

interface Empilhavel {
    fun empilhar(dado: Any)
    fun desempilhar(): Any?
    fun atualizar(dado: Any)
    fun espiar(): Any?
    fun estaVazia(): Boolean
    fun estaCheia(): Boolean
    fun imprimir(): String
}

data class NoDuploPilha(var dado: Any) {
    var proximo: NoDuploPilha? = null
    var anterior: NoDuploPilha? = null
}

class PilhaDinamica(private var tamanho: Int = 10) : Empilhavel {
    private var ponteiroTopo: NoDuploPilha? = null
    private var quantidade = 0

    override fun empilhar(dado: Any) {
        if (!estaCheia()) {
            var novoNo = NoDuploPilha(dado)
            novoNo.anterior = ponteiroTopo
            if (!estaVazia()) {
                ponteiroTopo?.proximo = novoNo
            }
            ponteiroTopo = novoNo
            quantidade++
        } else {
            throw IndexOutOfBoundsException("A pilha está cheia!")
        }
    }

    override fun desempilhar(): Any? {
        var auxDado: Any? = null
        if (!estaVazia()) {
            auxDado = ponteiroTopo?.dado
            ponteiroTopo = ponteiroTopo?.anterior
            quantidade--
            if (!estaCheia()) {
                ponteiroTopo?.proximo = null
            }
        } else {
            throw IndexOutOfBoundsException("A pilha está vazia!")
        }
        return auxDado
    }

    override fun atualizar(dado: Any) {
        if (!estaVazia()) {
            ponteiroTopo?.dado = dado
        } else {
            throw IndexOutOfBoundsException("A pilha está vazia!")
        }
    }

    override fun espiar(): Any? {
        return ponteiroTopo?.dado
    }

    override fun estaVazia(): Boolean {
        return quantidade == 0
    }

    override fun estaCheia(): Boolean {
        return quantidade == tamanho
    }

    override fun imprimir(): String {
        var resultado = "["
        var noAtual = ponteiroTopo
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

fun ehPalindromo(dado: String): Boolean {
    val pilhaDinamica = PilhaDinamica()
    // empilhar todos os caracteres da string
    for (i in 0 until dado.length) {
        pilhaDinamica.empilhar(dado[i])
    }
    // desempilhar e comparar com a letra da string
    // se for diferente, não é palíndromo
    // se for igual, continua até o final
    for (i in 0 until dado.length) {
        if (pilhaDinamica.desempilhar() != dado[i]) {
            return false
        }
    }
    return true
}