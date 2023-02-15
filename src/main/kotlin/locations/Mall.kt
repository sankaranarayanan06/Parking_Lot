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


    override fun parkVehicle(vehicle: Vehicle, freeSpot: Int): Boolean {
        when (vehicle) {
            is Bike, is Scooter -> {
                twoWheelerParkingSpot[freeSpot] = true
                return true
            }

            is Car, is Suv -> {
                lightVehicleParkingSpot[freeSpot] = true
                return true
            }

            is Truck, is Bus -> {
                heavyVehicleParkingSpot[freeSpot] = true
                return true
            }
        }
        return false
    }

    override fun unParkVehicle(vehicle: Vehicle, parkedSpot: Int):Boolean{
        when (vehicle) {
            is Bike, is Scooter -> {
                twoWheelerParkingSpot[parkedSpot] = false
                return true
            }

            is Car, is Suv -> {
                lightVehicleParkingSpot[parkedSpot] = false
                return true
            }

            is Truck, is Bus -> {
                heavyVehicleParkingSpot[parkedSpot] = false
                return true
            }
        }
        return false
    }

    override fun calculateFee(vehicle:Vehicle,parkedDuration: Long):Long{
        var fees:Long = 0
        when (vehicle) {
            is Bike, is Scooter -> {
                fees = parkedDuration * twoWheelerParkingCharge
            }

            is Car, is Suv -> {
                fees = parkedDuration * lightVehicleParkingCharge
            }

            is Truck, is Bus -> {
                fees = parkedDuration * heavyVehicleParkingCharge
            }
        }
        TOTAL_MALL_FEE += fees
        return fees
    }
}