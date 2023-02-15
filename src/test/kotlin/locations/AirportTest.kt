package locations

import FactoryLocation
import FactoryVehicle
import Location.AIRPORT
import VehicleType.BIKE
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class AirportTest {
    @Test
    fun `it should return a free spot in airport`() {
        //Arrange
        val location = FactoryLocation().getLocationInstance(AIRPORT)
        val vehicle = FactoryVehicle().getVehicleInstance(BIKE)
        val expectedSpot = 0

        //Act
        val spot = location.getFreeSpot(vehicle)

        //Assert
        Assertions.assertEquals(expectedSpot, spot)
    }

    @Test
    fun `it should return spot is unavailable`() {
        //Arrange
        val location = FactoryLocation().getLocationInstance(AIRPORT)
        val vehicle = FactoryVehicle().getVehicleInstance(BIKE)
        var spot: Int
        for (i in 0..199) {
            spot = location.getFreeSpot(vehicle)
            location.parkVehicle(vehicle, spot)
        }
        val expectedSpot = -1

        //Act
        spot = location.getFreeSpot(vehicle)

        //Assert
        Assertions.assertEquals(expectedSpot, spot)
    }

    @Test
    fun `it should park a bike at the given spot in airport`() {
        //Arrange
        val location = FactoryLocation().getLocationInstance(AIRPORT)
        val vehicle = FactoryVehicle().getVehicleInstance(BIKE)
        val expectedSpot = 0
        val spot = location.getFreeSpot(vehicle)

        //Act
        val response = location.parkVehicle(vehicle, spot)

        //Assert
        Assertions.assertEquals(expectedSpot, spot)
        Assertions.assertTrue(response)
    }

    @Test
    fun `it should unpark a bike at the given spot in airport`() {
        //Arrange
        val location = FactoryLocation().getLocationInstance(AIRPORT)
        val vehicle = FactoryVehicle().getVehicleInstance(BIKE)
        val expectedSpot = 0
        val spot = location.getFreeSpot(vehicle)
        location.parkVehicle(vehicle, spot)

        //Act
        val response = location.unParkVehicle(vehicle, spot)

        //Assert
        Assertions.assertEquals(expectedSpot, spot)
        Assertions.assertTrue(response)
    }

}