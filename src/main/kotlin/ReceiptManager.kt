import locations.ParkLocation
import java.util.*
import kotlin.math.ceil

class ReceiptManager(
    private var exitDate: Date = Date(),
    private var receiptNumber: Int = RECEIPT_NUMBER++,
    private var location: ParkLocation,
    private var ticket: TicketManager
) {
    private var fee: Long = 0

    init {
        fee = this.location.calculateFee(ticket.getVehicle(), calculateParkedDuration(ticket))
    }

    fun generateReceipt(): String {
        return "Parking Receipt:\n\t" +
                "Receipt Number:\t$receiptNumber\n\t" +
                "Entry Date:\t${ticket.getEntryDate()}\n\t" +
                "Exit Date:\t${exitDate}\n\t" +
                "Fees:\t$fee\n\t"
    }

    private fun calculateParkedDuration(ticket: TicketManager): Long {
        return ceil((exitDate.time - ticket.getEntryDate().time).toDouble() / 3600000).toLong()

    }
}