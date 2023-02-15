abstract class Vehicle {
    protected var vehicleNumber: String = ""

    abstract fun setVehicleEntry(id: String)
}

class Bike : Vehicle() {
    override fun setVehicleEntry(id: String) {
        this.vehicleNumber = id
    }
}

class Scooter : Vehicle() {
    override fun setVehicleEntry(id: String) {
        this.vehicleNumber = id
    }
}

class Car : Vehicle() {
    override fun setVehicleEntry(id: String) {
        this.vehicleNumber = id
    }
}

class Suv : Vehicle() {
    override fun setVehicleEntry(id: String) {
        this.vehicleNumber = id
    }
}

class Truck : Vehicle() {
    override fun setVehicleEntry(id: String) {
        this.vehicleNumber = id
    }
}

class Bus : Vehicle() {
    override fun setVehicleEntry(id: String) {
        this.vehicleNumber = id
    }
}
