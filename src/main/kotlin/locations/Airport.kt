package locations

import Vehicle

class Airport : ParkLocation() {
    private var numberOfTwoWheelerSpot: Int = 200
    private var numberOfLightVehicleSpot: Int = 500
    private var numberOfHeavyVehicleSpot: Int = 100

    private var availableTwoWheelerSpot = mutableListOf<Pair<Int, Vehicle>>()
    private var availableLightVehicleSpot = mutableListOf<Pair<Int, Vehicle>>()
    private var availableHeavyVehicleSpot = mutableListOf<Pair<Int, Vehicle>>()

    override fun getFreeSpot(vehicle: Vehicle): Int {
        TODO("IMPLEMENTATION")
    }

    override fun calculateFee(vehicle: Vehicle, parkedDuration: Long): Long {
        TODO("IMPLEMENTATION")
    }

    override fun parkVehicle(vehicle: Vehicle, freeSpot: Int): Boolean {
        TODO("Not yet implemented")
    }

    override fun unParkVehicle(vehicle: Vehicle, parkedSpot: Int): Boolean {
        TODO("Not yet implemented")
    }

}
