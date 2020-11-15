import java.util.ArrayList;
//import java.util.Date;

public class Booking {
    public String BookingDate;
    public int bookingTable;
    public ArrayList<Order>  orders;

    public Booking() {
        orders = new ArrayList<>();
    }

    public ArrayList<Order> getOrder() {
        return orders;
    }

    public String getBookingDate() {
        return this.BookingDate;
    }
    public int getBookingTable() {
        return bookingTable;
    }


    public void setBookingDate(String bookingDate) {
        BookingDate = bookingDate;
    }


    public void setBookingTable(int bookingTable) {
        this.bookingTable = bookingTable;
    }

    public void setOrders(Order orders) {
        this.orders.add(orders);
    }

    public  void makeOrder(String Details, String Description ) {
        Order pop = new Order();
        pop.setDetails(Details);
        pop.setDescription(Description);
        setOrders(pop);
    }


}
