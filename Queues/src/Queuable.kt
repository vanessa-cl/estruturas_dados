interface Queuable {

    // métodos auxiliares
    fun isFull(): Boolean
    fun isEmpty(): Boolean
    fun print(): String

    // métodos principais
    fun enqueue(data: Any?)     // C
    fun front(): Any?           // R -> semelhante ao peek
    fun update(data: Any?)      // U
    fun dequeue(): Any?         // D

}