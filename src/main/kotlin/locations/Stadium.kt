package locations

import Bike
import Car
import Scooter
import Suv
import TOTAL_STADIUM_FEE
import Vehicle
import java.util.*

class Stadium : ParkLocation() {
    private var numberOfTwoWheelerSpot: Int = 1000
    private var numberOfLightVehicleSpot: Int = 1500

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

    override fun unParkVehicle(vehicle: Vehicle, parkedSpot: Int): Boolean {
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

    override fun calculateFee(vehicle: Vehicle, parkedDuration: Long): Long {
        var fees: Long = 0
        when (vehicle) {
            is Bike, is Scooter -> {
                when (parkedDuration) {
                    in 0 until 4 -> {
                        fees += 30
                    }

                    in 4 until 12 -> {
                        fees += 90
                    }

                    else -> {
                        val duration = parkedDuration - 12
                        fees += duration * 100
                    }
                }
            }

            is Car, is Suv -> {
                when (parkedDuration) {
                    in 0 until 4 -> {
                        fees += 60
                    }

                    in 4 until 12 -> {
                        fees += 120
                    }

                    else -> {
                        fees += 120 + ((parkedDuration - 12) * 200)
                    }
                }
            }

        }
        TOTAL_STADIUM_FEE += fees
        return fees
    }
}
