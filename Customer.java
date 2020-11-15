import java.util.ArrayList;

public class Customer {
       public int ssn;
       public String name;
       public Character Gender;
       public String dateOfBirth;
       public String registrationDate;
       public ArrayList<Booking> bookings;
       
       public Customer() {
    	   
    	   bookings = new ArrayList<>();
    	  
       }
       

    public int getSsn() {
        return ssn;
    }

    public void setSsn(int ssn) {
        this.ssn = ssn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Character getGender() {
        return Gender;
    }

    public void setGender(Character gender) {
        Gender = gender;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(String registrationDate) {
        this.registrationDate = registrationDate;
    }

    public ArrayList<Booking> getBooking() {
        return bookings;
    }

    public void setBooking(Booking booking) {
       this.bookings.add(booking);
    }

    public  void makeBooking(int x, String y ) {
           Booking pop = new Booking();
           pop.setBookingTable(x);
           pop.setBookingDate(y);
           //this.bookings.add(pop);
           setBooking(pop);
    }

}
