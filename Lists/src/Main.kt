fun main() {

    var l1 = CircularStaticList(5)

    l1.append("A")
    println("Start Pointer: ${l1.getStartPointer()}")
    println("End Pointer: ${l1.getEndPointer()}")
    println("Quantity: ${l1.getQuantity()}")
    print("Array após alterações: ")
    println(l1.getList().contentToString())
    println("___________________________")
    l1.append("B")
    println("Start Pointer: ${l1.getStartPointer()}")
    println("End Pointer: ${l1.getEndPointer()}")
    println("Quantity: ${l1.getQuantity()}")
    print("Array após alterações: ")
    println(l1.getList().contentToString())
    println("___________________________")
    l1.append("C")
    println("Start Pointer: ${l1.getStartPointer()}")
    println("End Pointer: ${l1.getEndPointer()}")
    println("Quantity: ${l1.getQuantity()}")
    print("Array após alterações: ")
    println(l1.getList().contentToString())
    println("___________________________")
    l1.append("D")
    println("Start Pointer: ${l1.getStartPointer()}")
    println("End Pointer: ${l1.getEndPointer()}")
    println("Quantity: ${l1.getQuantity()}")
    print("Array após alterações: ")
    println(l1.getList().contentToString())
    println("___________________________")
//    l1.append("E")
//    println("Start Pointer: ${l1.getStartPointer()}")
//    println("End Pointer: ${l1.getEndPointer()}")
//    println("Quantity: ${l1.getQuantity()}")
//    print("Array após alterações: ")
//    println(l1.getList().contentToString())
//    println("___________________________")

    // inserir "X" na posição 3
    l1.insert(3,"X")
    println("Start Pointer: ${l1.getStartPointer()}")
    println("End Pointer: ${l1.getEndPointer()}")
    println("Quantity: ${l1.getQuantity()}")
    print("Array após alterações: ")
    println(l1.getList().contentToString())
    println("___________________________")

    // inserir "A" na posição 0
//    l1.insert(0,"A")
//    println("Start Pointer: ${l1.getStartPointer()}")
//    println("End Pointer: ${l1.getEndPointer()}")
//    println("Quantity: ${l1.getQuantity()}")
//    print("Array após alterações: ")
//    println(l1.getList().contentToString())
//    println("___________________________")
//
//    // inserir "D" na posição 3
//    l1.insert(3,"D")
//    println("Start Pointer: ${l1.getStartPointer()}")
//    println("End Pointer: ${l1.getEndPointer()}")
//    println("Quantity: ${l1.getQuantity()}")
//    print("Array após alterações: ")
//    println(l1.getList().contentToString())
//    println("___________________________")
//
//    // selecionar "B" na posição 1
//    println("Dado selecionado: ${l1.select(1)}")
//    println("Start Pointer: ${l1.getStartPointer()}")
//    println("End Pointer: ${l1.getEndPointer()}")
//    println("Quantity: ${l1.getQuantity()}")
//    print("Array após alterações: ")
//    println(l1.getList().contentToString())
//    println("___________________________")

    // atualizar "A" na posição 0 para "F"
//    l1.update(0,"F")
//    println("Start Pointer: ${l1.getStartPointer()}")
//    println("End Pointer: ${l1.getEndPointer()}")
//    println("Quantity: ${l1.getQuantity()}")
//    print("Array após alterações: ")
//    println(l1.getList().contentToString())
//    println("___________________________")

    // remover "A" da posição 0
//    println("Dado removido: ${l1.delete(0)}")
//    println("Start Pointer: ${l1.getStartPointer()}")
//    println("End Pointer: ${l1.getEndPointer()}")
//    println("Quantity: ${l1.getQuantity()}")
//    print("Array após alterações: ")
//    println(l1.getList().contentToString())
//    println("___________________________")

    // remover "E" da posição 3
//    println("Dado removido: ${l1.delete(3)}")
//    println("Start Pointer: ${l1.getStartPointer()}")
//    println("End Pointer: ${l1.getEndPointer()}")
//    println("Quantity: ${l1.getQuantity()}")
//    print("Array após alterações: ")
//    println(l1.getList().contentToString())
//    println("___________________________")

    // limpar a lista
//    l1.clear()
//    println("Start Pointer: ${l1.getStartPointer()}")
//    println("End Pointer: ${l1.getEndPointer()}")
//    println("Quantity: ${l1.getQuantity()}")
//    print("Array após alterações: ")
//    println(l1.getList().contentToString())
//    println("___________________________")

    // selecionar todos os dados
//    println(l1.selectAll().contentToString())
}