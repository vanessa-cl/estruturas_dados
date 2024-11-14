// Resposta da questão 1 da prova de 2024.1

// 0. Controle de contatos em um aplicativo de telefone.
class Contato(private var nome: String, private var telefone: String) {
}

interface Contatos : Listable {
    // adiciona um contato na lista
    fun adicionarContato(contato: Contato)

    // busca um contato pelo nome
    fun buscarContato(nome: String): Contato?

    // conta a quantidade de contatos
    fun contarContatos(): Int

    // lista todos os contatos
    fun listarContatos(): Array<Contato>

    // atualiza um contato
    fun atualizarContato(contato: Contato)

    // remove um contato da lista
    fun removerContato(contato: Contato)

    // limpa todos os contatos
    fun limparContatos(): Boolean

    // verifica se a lista de contatos está vazia
    fun listaEstaVazia(): Boolean

    // verifica se a lista de contatos está cheia
    fun listaEstaCheia(): Boolean
}

// 1. Controle de itens em um carrinho de compras online.
class Item(private var id: Int, private var nome: String, private var preco: Double) {
}









interface GestaoEncomendas {

    // insere uma encomenda na posição indicada
    fun inserirEncomenda(posicao: Int, encomenda: Encomenda)

    // adiciona uma encomenda na posição final da lista
    fun adicionarEncomenda(encomenda: Encomenda)

    // seleciona uma encomenda na posição indicada
    fun selecionarEncomenda(posicao: Int): Encomenda

    // selecionada todas as encomendas na lista
    fun selecionarTodasEncomendas(): Array<Encomenda>

    // atualiza uma encomenda na posição indicada
    fun atualizarEncomenda(posicao: Int, encomenda: Encomenda)

    // deleta uma encomenda na posição indicada
    fun deletarEncomenda(posicao: Int): Encomenda

    // deleta todas as encomendas da lista
    fun limparLista(): Boolean

}





class Encomenda(private var id: Int, private var destinatario: String, private var endereco: String) {
}


