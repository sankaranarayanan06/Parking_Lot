import Location.*
import locations.Airport
import locations.Mall
import locations.ParkLocation
import locations.Stadium

class FactoryLocation {
    fun getLocationInstance(type: Location): ParkLocation {
        return when (type) {
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