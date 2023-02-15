package locations

import Bike
import Bus
import Car
import Scooter
import Suv
import TOTAL_MALL_FEE
import Truck
import Vehicle
import java.util.*

class Mall : ParkLocation() {
    private var numberOfTwoWheelerSpot: Int = 100
    private var numberOfLightVehicleSpot: Int = 80
    private var numberOfHeavyVehicleSpot: Int = 10

    private var twoWheelerParkingSpot: MutableList<Boolean> =
        Collections.nCopies(numberOfTwoWheelerSpot, false).toMutableList()
    private var lightVehicleParkingSpot: MutableList<Boolean> =
        Collections.nCopies(numberOfLightVehicleSpot, false).toMutableList()
    private var heavyVehicleParkingSpot: MutableList<Boolean> =
        Collections.nCopies(numberOfHeavyVehicleSpot, false).toMutableList()

    private val twoWheelerParkingCharge = 10
    private val lightVehicleParkingCharge = 20
    private val heavyVehicleParkingCharge = 50


    override fun getFreeSpot(vehicle: Vehicle): Int {
        var freeSpot = -1
        if (vehicle is Bike || vehicle is Scooter) {
            freeSpot = checkForFreeSpotAvailability(twoWheelerParkingSpot, numberOfTwoWheelerSpot)
        } else if (vehicle is Car || vehicle is Suv) {
            freeSpot = checkForFreeSpotAvailability(lightVehicleParkingSpot, numberOfLightVehicleSpot)
        } else if (vehicle is Truck || vehicle is Bus) {
            freeSpot = checkForFreeSpotAvailability(heavyVehicleParkingSpot, numberOfHeavyVehicleSpot)
        }
        return freeSpot
    }


    override fun parkVehicle(vehicle: Vehicle, freeSpot: Int) {
        when (vehicle) {
            is Bike, is Scooter -> {
                twoWheelerParkingSpot[freeSpot] = true
            }

            is Car, is Suv -> {
                lightVehicleParkingSpot[freeSpot] = true
            }

            is Truck, is Bus -> {
                heavyVehicleParkingSpot[freeSpot] = true
            }
        }
    }

    override fun unParkVehicle(vehicle: Vehicle, parkedSpot: Int){
        when (vehicle) {
            is Bike, is Scooter -> {
                twoWheelerParkingSpot[parkedSpot] = false
            }

            is Car, is Suv -> {
                lightVehicleParkingSpot[parkedSpot] = false
            }

            is Truck, is Bus -> {
                heavyVehicleParkingSpot[parkedSpot] = false
            }
        }
    }

    override fun calculateFee(vehicle:Vehicle,parkedDuration: Long):Long{
        var fees:Long = 0
        if (vehicle is Bike || vehicle is Scooter){
            fees = parkedDuration * twoWheelerParkingCharge
        }else if (vehicle is Car || vehicle is Suv){
            fees = parkedDuration * lightVehicleParkingCharge
        }else if (vehicle is Truck || vehicle is Bus){
            fees = parkedDuration * heavyVehicleParkingCharge
        }
        TOTAL_MALL_FEE += fees
        return fees
    }
}