import Location.MALL
import VehicleType.BIKE

fun main(args: Array<String>) {
    //Get the location, vehicle and the vehicle number as input

    //Get the Object from factory Vehicle
    val vehicle = FactoryVehicle().getVehicleInstance(BIKE)

    //Get the Object from factory Location
    val location = FactoryLocation().getVehicleInstance(MALL)

    //Initialize vehicle class

    //Get the free spot in the desired location

    //Park the vehicle

    //Generate the ticket

    //UnPark the vehicle from the spot

    //Get the receipt

    //Get the money from the user

    //Add it to the owner
}