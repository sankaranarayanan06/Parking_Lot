
import Location.MALL
import VehicleType.BIKE
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.util.*

class ReceiptManagerTest{

    @Test
    fun `it should generate receipt`(){
        //Arrange
        val location = FactoryLocation().getVehicleInstance(MALL)
        val vehicle = FactoryVehicle().getVehicleInstance(BIKE)
        val parkedSpot = location.getFreeSpot(vehicle)
        location.parkVehicle(vehicle,parkedSpot)
        val ticket = TicketManager(entryDate = Date(), vehicle = vehicle)
//        sleep(5000)
        location.unParkVehicle(vehicle,parkedSpot)
        ticket.generateTicket()
        val expectedResponse =
                "Parking Receipt:\n\t" +
                "Receipt Number:\t0\n\t" +
                "Entry Date:\t${ticket.getEntryDate()}\n\t" +
                "Exit Date:\t${Date()}\n\t" +
                "Fees:\t10\n\t"

        //Act
        val receipt = ReceiptManager(location = location, ticket = ticket)
        val response = receipt.generateReceipt()
        
        //Assert
        assertEquals(expectedResponse,response)
    }
}