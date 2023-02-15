package locations

import Vehicle

abstract class ParkLocation {
    abstract fun getFreeSpot(vehicle: Vehicle): Int
    abstract fun parkVehicle(vehicle: Vehicle, freeSpot: Int): Boolean
    abstract fun unParkVehicle(vehicle: Vehicle, parkedSpot: Int): Boolean
    abstract fun calculateFee(vehicle: Vehicle, parkedDuration: Long): Long

    protected fun checkForFreeSpotAvailability(parkingLot: MutableList<Boolean>, numberOfTwoWheelerSpot: Int): Int {
        for (availableSpot in 0 until numberOfTwoWheelerSpot) {
            if (!parkingLot[availableSpot]) {
                return availableSpot
            }
        }
        return -1
    }
}

