package action

import domain.Rovers

class SendCommandToRover(val rovers: Rovers) {
    fun execute(id: Int, command: String): String {
//        val rover = rovers.findById(id)

//        rover.move(command)

        return "10NOK"
    }
}
