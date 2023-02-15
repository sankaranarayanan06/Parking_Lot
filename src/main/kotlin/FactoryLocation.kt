import Location.*
import locations.Airport
import locations.Mall
import locations.ParkLocation
import locations.Stadium

class FactoryLocation {
    fun getVehicleInstance(type:Location):ParkLocation{
        return when(type){
            AIRPORT -> {
                Airport()
            }
            STADIUM -> {
                Stadium()
            }
            MALL -> {
                Mall()
            }
        }
    }
}