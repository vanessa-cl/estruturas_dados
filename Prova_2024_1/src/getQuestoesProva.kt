// Acredito que essa lógica será utilizada para cada um obter os números
// das questões de acordo com o número de matrícula na prova

import kotlin.random.Random

fun getQuestoesProva(matricula: String): Array<Int> {
    var numeroAleatorio = Random.nextInt(0, 99)
    var somatorioMatricula = 0
    for (i in 0..<matricula.length) {
        somatorioMatricula += matricula[i].digitToInt()
    }
    var soma = somatorioMatricula + numeroAleatorio
    var questao1 = (soma * 1) % 6
    var questao2 = (soma * 2) % 20
    var questao3 = (soma * 3) % 20
    return arrayOf(questao1, questao2, questao3)
}