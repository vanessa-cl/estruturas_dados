interface Heaping<T> {
    // métodos principais
    fun insert(data: T)  // C -> Create
    fun get(): T?        // R -> Read
    fun update(data: T)  // U -> Update
    fun remove(): T?     // D -> Delete

    // métodos auxiliares
    fun print(): String
    fun isEmpty(): Boolean
    fun isFull(): Boolean
}