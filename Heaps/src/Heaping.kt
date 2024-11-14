interface Heaping {
    // métodos principais
    fun insert(data: Long)  // C -> Create
    fun get(): Long?        // R -> Read
    fun update(data: Long)  // U -> Update
    fun remove(): Long?     // D -> Delete

    // métodos auxiliares
    fun print(): String
    fun isEmpty(): Boolean
    fun isFull(): Boolean
}