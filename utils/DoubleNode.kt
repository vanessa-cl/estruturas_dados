package utils// POJO no Java é uma classe que possui apenas atributos e métodos de acesso (getters e setters).
// No Kotlin, essas classes são chamadas de Data Classes.

// Os nós duplamente encadeados possuem um ponteiro para o nó anterior e outro para o próximo nó.
data class DoubleNode(var data: Any?) {
    var previous: DoubleNode? = null
    var next: DoubleNode? = null
}
