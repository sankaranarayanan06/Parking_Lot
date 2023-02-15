
import Location.MALL
import VehicleType.BIKE
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.util.*

class TicketManagerTest{
    @Test
    fun `it should generate a ticket for a bike to be parked in the mall`(){
        //Arrange
        val location = FactoryLocation().getVehicleInstance(MALL)
        val vehicle = FactoryVehicle().getVehicleInstance(BIKE)
        val spot = location.getFreeSpot(vehicle)
        location.parkVehicle(vehicle,spot)
        val ticket = TicketManager(entryDate = Date(), vehicle = vehicle)
        val expectedResponse = "Parking Ticket:\n\t" +
                "Ticket Number:\t0\n\t" +
                "Spot number:\t0\n\t" +
                "Entry Date:\t${Date()}"

        //Act
        val response = ticket.generateTicket()

        //Assert
        Assertions.assertEquals(expectedResponse,response)
    }
}