package locations

import Bike
import Car
import Scooter
import Suv
import Vehicle
import java.util.*

class Airport : ParkLocation() {
    private var numberOfTwoWheelerSpot: Int = 200
    private var numberOfLightVehicleSpot: Int = 500

    private var twoWheelerParkingSpot: MutableList<Boolean> =
        Collections.nCopies(numberOfTwoWheelerSpot, false).toMutableList()
    private var lightVehicleParkingSpot: MutableList<Boolean> =
        Collections.nCopies(numberOfLightVehicleSpot, false).toMutableList()

    override fun getFreeSpot(vehicle: Vehicle): Int {
        var freeSpot = -1
        when (vehicle) {
            is Bike, is Scooter -> {
                freeSpot = checkForFreeSpotAvailability(twoWheelerParkingSpot, numberOfTwoWheelerSpot)
            }

            is Car, is Suv -> {
                freeSpot = checkForFreeSpotAvailability(lightVehicleParkingSpot, numberOfLightVehicleSpot)
            }
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
        }
        return false
    }

    override fun calculateFee(vehicle:Vehicle,parkedDuration: Long):Long{
        var fees:Long = 0
        when (vehicle) {
            is Bike, is Scooter -> {
                when (parkedDuration) {
                    in 0 until 1 -> {
                        fees = 0
                    }
                    in 1 until 8 -> {
                        fees += 40
                    }
                    in 8 until 24 -> {
                        fees += 60
                    }
                    else -> {
                        val numberOfDays = parkedDuration/24
                        fees = numberOfDays * 80
                    }
                }
            }

            is Car, is Suv -> {
                when (parkedDuration) {
                    in 0 until 12 -> {
                        fees = 60
                    }
                    in 12 until 24 -> {
                        fees += 80
                    }
                    else -> {
                        val numberOfDays = parkedDuration/24
                        fees = numberOfDays * 100
                    }
                }
            }
        }
        return fees
    }
}
