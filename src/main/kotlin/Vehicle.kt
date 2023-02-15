abstract class Vehicle {
    protected var vehicleNumber: String = ""

    abstract fun setVehicleRegistrationNumber(id: String)
}

class Bike : Vehicle() {
    override fun setVehicleRegistrationNumber(id: String) {
        this.vehicleNumber = id
    }
}

class Scooter : Vehicle() {
    override fun setVehicleRegistrationNumber(id: String) {
        this.vehicleNumber = id
    }
}

class Car : Vehicle() {
    override fun setVehicleRegistrationNumber(id: String) {
        this.vehicleNumber = id
    }
}

class Suv : Vehicle() {
    override fun setVehicleRegistrationNumber(id: String) {
        this.vehicleNumber = id
    }
}

class Truck : Vehicle() {
    override fun setVehicleRegistrationNumber(id: String) {
        this.vehicleNumber = id
    }
}

class Bus : Vehicle() {
    override fun setVehicleRegistrationNumber(id: String) {
        this.vehicleNumber = id
    }
}
