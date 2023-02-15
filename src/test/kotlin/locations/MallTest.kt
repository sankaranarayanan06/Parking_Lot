package locations

import FactoryLocation
import FactoryVehicle
import Location.MALL
import VehicleType.BIKE
import org.junit.jupiter.api.Assertions
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
        location.parkVehicle(vehicle,spot)

        //Assert
        Assertions.assertEquals(expectedSpot,spot)
    }

    @Test
    fun `it should return spot is unavailable`(){
        //Arrange
        val location = FactoryLocation().getVehicleInstance(MALL)
        val vehicle = FactoryVehicle().getVehicleInstance(BIKE)
        val expectedSpot = -1

        //Act
        var spot = 0
        for (i in 0..99){
            spot = location.getFreeSpot(vehicle)
            location.parkVehicle(vehicle,spot)
        }
        spot = location.getFreeSpot(vehicle)

        //Assert
        Assertions.assertEquals(expectedSpot,spot)
    }
}