import locations.ParkLocation
import java.util.*

class ReceiptManager(
    private var exitDate:Date = Date(),
    private var receiptNumber:Int = RECEIPT_NUMBER++,
    private var location: ParkLocation,
    private var ticket: TicketManager
){
    private var fee:Long = 0
    init {
        fee = this.location.calculateFee(ticket.getVehicle(),calculateParkedDuration(ticket))
    }

    fun generateReceipt(ticket: TicketManager): String {
        return "Parking Receipt:\n\t" +
                "Receipt Number:\t$receiptNumber\n\t" +
                "Entry Date:\t${ticket.getEntryDate()}\n\t"
                "Fees:\t$fee\n\t"
    }

    fun calculateParkedDuration(ticket: TicketManager): Long{
        return ticket.getEntryDate().toString().toLong() - exitDate.toString().toLong()
    }
}