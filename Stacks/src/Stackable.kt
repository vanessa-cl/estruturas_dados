interface Stackable {

    // métodos auxiliares
    fun isEmpty(): Boolean
    fun isFull(): Boolean
    fun print(): String

    // métodos principais
    fun push(data: Any?)    // CREATE
    fun peek(): Any?        // READ
    fun update(data: Any?)  // UPDATE
    fun pop(): Any?         // DELETE

}