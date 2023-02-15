import VehicleType.*

class FactoryVehicle {
    fun getVehicleInstance(type:VehicleType):Vehicle{
         return when(type){
            BIKE -> {
                 Bike()
            }
            SCOOTER -> {
                 Scooter()
            }
            CAR -> {
                 Car()
            }
            SUV -> {
                 Suv()
            }
            TRUCK -> {
                 Truck()
            }
            BUS -> {
                 Bus()
            }
        }
    }
}