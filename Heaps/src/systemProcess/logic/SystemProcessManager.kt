package systemProcess.logic

import systemProcess.collections.SystemProcessHeap
import systemProcess.entities.SystemProcess
import systemProcess.util.ProcessState

class SystemProcessManager {
    private val readyProcessHeap = SystemProcessHeap(5)
    private val runningProcessHeap = SystemProcessHeap(3)
    private val finishedProcessList = mutableListOf<SystemProcess?>()

    fun showMenu() {
        println("___________________________________________________________________________________")
        println("Welcome to the System Process Heap!")
        println("Choose an option:")
        println("1. Create a process")
        println("2. Finish a process")
        println("3. Execute the highest priority process")
        println("4. Print the ready processes")
        println("5. Print the running processes")
        println("6. Print the finished processes")
        println("7. Exit")
        println("___________________________________________________________________________________")
    }

    fun createProcess() {
        println("Enter the process name:")
        val name: String = readln()
        println("Enter the process description:")
        val description: String = readln()
        val process = SystemProcess(name, description)
        readyProcessHeap.insert(process)
        println("Created new process '${process.name}' with ready state and inserted into the heap!")
    }

    fun finishProcess() {
        val highestPriorityProcess = runningProcessHeap.get() ?: return
        highestPriorityProcess.state = ProcessState.FINISHED
        runningProcessHeap.remove()
        finishedProcessList.add(highestPriorityProcess)
        println("Finishing process: ${highestPriorityProcess.name}")
    }

    fun executeHighestPriorityProcess() {
        if (runningProcessHeap.isFull()) {
            println("Maximum number of running processes reached! Please, finish a process to execute a new one.")
            return
        }
        val highestPriorityProcess = readyProcessHeap.get() ?: return
        if (highestPriorityProcess.state == ProcessState.READY) {
            highestPriorityProcess.state = ProcessState.RUNNING
            runningProcessHeap.insert(highestPriorityProcess)
            readyProcessHeap.remove()
            println("Now executing process: ${highestPriorityProcess.name}")
        }
    }

    fun printReadyProcesses() {
        if (readyProcessHeap.isEmpty()) {
            println("No ready process in the heap!")
            return
        }
        println("Printing the ready process heap:")
        readyProcessHeap.printProcesses()
    }

    fun printRunningProcesses() {
        if (runningProcessHeap.isEmpty()) {
            println("No running processes in the heap!")
            return
        }
        println("Printing the running processes heap:")
        runningProcessHeap.printProcesses()
    }

    fun printFinishedProcesses() {
        if (finishedProcessList.isEmpty()) {
            println("No finished processes in the list!")
            return
        }
        println("Printing the finished processes list:")
        finishedProcessList.forEach {
            println("___________________________________________________________________________________")
            println("${it?.toString()}")
        }
    }
}