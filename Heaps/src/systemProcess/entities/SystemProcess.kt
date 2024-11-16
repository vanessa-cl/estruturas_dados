package systemProcess.entities

import systemProcess.util.ProcessState
import kotlin.random.Random

class SystemProcess(val name: String, val description: String) {
    val id: Int = Random.nextInt(1, 10)
    var state: ProcessState = ProcessState.READY
    var priority: Int = Random.nextInt(1, 10)
    var memory: Int = Random.nextInt(1, 1000)

    override fun toString(): String {
        return "ID: $id, Name: $name, Description: $description, Priority: $priority, Memory: $memory, State: $state"
    }
}