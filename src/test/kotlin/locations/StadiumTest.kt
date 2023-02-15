package locations

import FactoryLocation
import FactoryVehicle
import Location.STADIUM
import VehicleType.CAR
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class StadiumTest {

    @Test
    fun `it should return a free spot in stadium`() {
        //Arrange
        val location = FactoryLocation().getLocationInstance(STADIUM)
        val vehicle = FactoryVehicle().getVehicleInstance(CAR)
        val expectedSpot = 0

        //Act
        val spot = location.getFreeSpot(vehicle)

        //Assert
        assertEquals(expectedSpot, spot)
    }

    @Test
    fun `it should return spot is unavailable`() {
        //Arrange
        val location = FactoryLocation().getLocationInstance(STADIUM)
        val vehicle = FactoryVehicle().getVehicleInstance(CAR)
        var spot: Int
        for (i in 0..1499) {
            spot = location.getFreeSpot(vehicle)
            location.parkVehicle(vehicle, spot)
        }
        val expectedSpot = -1

        //Act
        spot = location.getFreeSpot(vehicle)

        //Assert
        assertEquals(expectedSpot, spot)
    }

    @Test
    fun `it should park a car at the given spot in stadium`() {
        //Arrange
        val location = FactoryLocation().getLocationInstance(STADIUM)
        val vehicle = FactoryVehicle().getVehicleInstance(CAR)
        val expectedSpot = 0
        val spot = location.getFreeSpot(vehicle)

        //Act
        val response = location.parkVehicle(vehicle, spot)

        //Assert
        assertEquals(expectedSpot, spot)
        assertTrue(response)
    }

    @Test
    fun `it should unpark a car at the given spot in stadium`() {
        //Arrange
        val location = FactoryLocation().getLocationInstance(STADIUM)
        val vehicle = FactoryVehicle().getVehicleInstance(CAR)
        val expectedSpot = 0
        val spot = location.getFreeSpot(vehicle)
        location.parkVehicle(vehicle, spot)

        //Act
        val response = location.unParkVehicle(vehicle, spot)

        //Assert
        assertEquals(expectedSpot, spot)
        assertTrue(response)
    }
}