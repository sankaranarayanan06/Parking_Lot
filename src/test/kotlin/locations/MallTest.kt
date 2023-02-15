package locations

import FactoryLocation
import FactoryVehicle
import Location.MALL
import VehicleType.BIKE
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class MallTest{

    @Test
    fun `it should return a free spot in mall`(){
        //Arrange
        val location = FactoryLocation().getVehicleInstance(MALL)
        val vehicle = FactoryVehicle().getVehicleInstance(BIKE)
        val expectedSpot = 0

        //Act
        val spot = location.getFreeSpot(vehicle)

        //Assert
        assertEquals(expectedSpot,spot)
    }

    @Test
    fun `it should return spot is unavailable`(){
        //Arrange
        val location = FactoryLocation().getVehicleInstance(MALL)
        val vehicle = FactoryVehicle().getVehicleInstance(BIKE)
        var spot = 0
        for (i in 0..99){
            spot = location.getFreeSpot(vehicle)
            location.parkVehicle(vehicle,spot)
        }
        val expectedSpot = -1

        //Act
        spot = location.getFreeSpot(vehicle)

        //Assert
        assertEquals(expectedSpot,spot)
    }

    @Test
    fun `it should park a bike at the given spot in mall`(){
        //Arrange
        val location = FactoryLocation().getVehicleInstance(MALL)
        val vehicle = FactoryVehicle().getVehicleInstance(BIKE)
        val expectedSpot = 0
        val spot = location.getFreeSpot(vehicle)

        //Act
        val response = location.parkVehicle(vehicle,spot)

        //Assert
        assertEquals(expectedSpot,spot)
        assertTrue(response)
    }

    @Test
    fun `it should unpark a bike at the given spot in mall`(){
        //Arrange
        val location = FactoryLocation().getVehicleInstance(MALL)
        val vehicle = FactoryVehicle().getVehicleInstance(BIKE)
        val expectedSpot = 0
        val spot = location.getFreeSpot(vehicle)
        location.parkVehicle(vehicle,spot)

        //Act
        val response = location.unParkVehicle(vehicle,spot)

        //Assert
        assertEquals(expectedSpot,spot)
        assertTrue(response)
    }
}