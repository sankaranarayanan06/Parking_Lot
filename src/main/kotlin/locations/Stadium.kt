package locations

import Vehicle

class Stadium : ParkLocation() {
    private var numberOfBikeSpot: Int = 1000
    private var numberOfCarSpot: Int = 1500

    private var availableBikeSpot = mutableListOf<Pair<Int, Vehicle>>()
    private var availableCarSpot = mutableListOf<Pair<Int, Vehicle>>()

    override fun getFreeSpot(vehicle: Vehicle): Int {
        TODO("IMPLEMENTATION")
    }

    override fun unParkVehicle(vehicle: Vehicle, parkedSpot: Int): Boolean {
        TODO("Not yet implemented")
    }

    override fun calculateFee(vehicle: Vehicle, parkedDuration: Long): Long {
        TODO("Not yet implemented")
    }

    override fun parkVehicle(vehicle: Vehicle, freeSpot: Int): Boolean {
        TODO("Not yet implemented")
    }
}
