import java.util.*

class TicketManager(
    private val entryDate: Date = Date(),
    private var ticketNumber: Int = TICKET_NUMBER++,
    private var parkedSpot: Int = 0,
    private val location: Location
) {
    fun generateTicket(): String {
        return "Parking Ticket:\n\t" +
                "Ticket Number:\t$ticketNumber\n\t" +
                "Spot number:\t$parkedSpot\n\t" +
                "Entry Date:\t$entryDate"
    }

    fun getEntryDate(): Date {
        return entryDate
    }

    fun getLocation(): Location {
        return location
    }

}