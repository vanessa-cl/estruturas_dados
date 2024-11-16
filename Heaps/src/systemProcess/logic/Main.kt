package systemProcess.logic

fun main() {
    val menu = SystemProcessManager()
    var option: Int
    var exit = false
    while (!exit) {
        menu.showMenu()
        option = readln().toInt()
        when (option) {
            1 -> menu.createProcess()
            2 -> menu.finishProcess()
            3 -> menu.executeHighestPriorityProcess()
            4 -> menu.printReadyProcesses()
            5 -> menu.printRunningProcesses()
            6 -> menu.printFinishedProcesses()
            7 -> exit = true
            else -> println("Invalid option! Try again.")
        }
    }
}