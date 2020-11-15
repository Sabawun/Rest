//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.awt.print.Book;
//import java.sql.Date;
//import java.text.SimpleDateFormat;
//import java.util.Objects;
import java.util.Scanner;


public class RestManApp {


    public static void main(String[] args) {
        PopulateData.populate();
        System.out.println("Welcome!!");
        boolean loop = true;
        while (loop) {
            System.out.println("Menu");
            System.out.println("1 Add Staff");
            System.out.println("2 Delete Staff");
            System.out.println("3 Staff Detail");
            System.out.println("4 Add Customer");
            System.out.println("5 Delete Customer");
            System.out.println("6 Receive Booking");
            System.out.println("7 Receive Order");
            System.out.println("8 Customer Details");
            System.out.println("9 Customer Booking");
            System.out.println("10 Customer Order");
            System.out.println("11 List Staff");
            System.out.println("12 List Customer");
            System.out.println("13 Exist");
            System.out.println("Please Choose an option: ");
            Scanner input = new Scanner(System.in);
            int option = input.nextInt();


            switch (option) {
                case (1) :
                {
                    System.out.println("---Adding a Staff Entry---");
                    addStaff();
                    break;
                }
                case (2) : {
                    System.out.println("---Deleting a Staff Entry---");
                    System.out.println("Please enter ssn number: ");
                    int identifier = input.nextInt();
                    deleteStaff(identifier);
                    break;
                }

                case (3) : {

                    System.out.println("---Getting Staff Details---");
                    System.out.println("Please enter ssn number: ");
                    int identifier = input.nextInt();
                    getStaffDetails(identifier);
                    break;
                }
                case (4) : {addCustomer();
                break;
                }
                
                case (5) : {
                    System.out.println("---Deleting Customer---");
                    System.out.println("Please enter ssn number: ");
                    int identifier = input.nextInt();
                    deleteCustomer(identifier);
                    break;
                }
                case (6) : {
                    System.out.println("---Customer Booking---");
                    System.out.println("Please enter ssn number : ");
                    int identifier = input.nextInt();
                    receiveBooking(identifier);
                    break;
                }
                case (7) : {
                    System.out.println("---Customer Order---");
                    System.out.println("Please enter ssn number: ");
                    int identifier = input.nextInt();
                    
                   // String pattern = "yyyy-MM-dd";
                   // SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
                    
                    System.out.println("Please enter booking date: ");
                    String DateIdentifier = input.next();
                    // 2020-05-25
                   // int yyyy = Integer.parseInt(date.substring(0,4));
                    //int MM = Integer.parseInt(date.substring(5,7));
                    //int dd = Integer.parseInt(date.substring(8,10));
                    
                    //System.out.println( "yyy: " + yyyy  + "MM: " + MM + "dd: " + dd);
                 
                  //  String DateIdentifier = simpleDateFormat.format(new Date( yyyy, MM, dd));
                    
                   // System.out.println(DateIdentifier);
                    
                    receiveOrder(identifier, DateIdentifier);
                    break;

                }
                case (8) : {
                    System.out.println("---Customer Details---");
                    System.out.println("Please enter ssn number: ");
                    int identifier = input.nextInt();
                    customerdetails(identifier);
                    break;
                }
                case (9) : {
                    System.out.println("---Customer Booking Information---");
                    System.out.println("Please enter ssn number: ");
                    int identifier = input.nextInt();
                    CustomerBooking(identifier);
                    break;
                }
                case (10) : {
                    System.out.println("---Customer Order Information---");
                    System.out.println("Please enter ssn number: ");
                    int identifier = input.nextInt();
                    System.out.println("Please enter booking date: ");
                    String DateIdentifier = input.next();
                    CustomerOrders(identifier, DateIdentifier);
                    break;
                }
                case (11) : {
                    System.out.println("---Listing Staff---");
                    listStaff();
                    break;
                }

                case (12) : {
                    System.out.println("---Listing Customer---");
                    listCustomer();
                    break;
                 }
                
                case (13) : {
                    loop = false;
                    exit();
                }
            }
        }
    }

    private static void exit() {
        System.out.println("Thank you for using this.");
        System.out.println("Regards, Sabawun Afzal Khattak");
        System.exit(1);

    }
    public static void listCustomer() {
        for (Customer value : PopulateData.customer) {
            System.out.println(value.name);
        }
    }
    public static void listStaff() {

        for (Staff value : PopulateData.staff) {
            System.out.println(value.name);
        }
    }

    public static void CustomerOrders(int y, String x) {
        boolean foundssn = false;
        boolean founddate = false;

        for (Customer value : PopulateData.customer) {

            if (value.getSsn() == y) {
                foundssn = true;
                for(Booking val : value.bookings ) {
                    if (val.getBookingDate().equals(x)) {
                        System.out.println("c1");
                        founddate=true;
                        for (int i =0; i<val.getOrder().size();i++) {
                            System.out.println(val.getOrder().get(i).details);
                            System.out.println(val.getOrder().get(i).description);
                        }
                    }
                }

                break;

            }
        }
        if (!foundssn) {
            System.out.println("SSN not found");
        }
        if (!founddate) {
            System.out.println("Date not found");
        }

    }

    public static void CustomerBooking(int y) {
        boolean foundssn = false;

        for (Customer value : PopulateData.customer) {

            if (value.getSsn() == y) {
                foundssn = true;
                
                for(int i = 0; i < value.getBooking().size(); i++) {
                    System.out.println(
                    		 "Booking Date" + value.getBooking().get(i).BookingDate);
                    System.out.println(
                    "Table " + value.getBooking().get(i).bookingTable);
                    
                    	
                }
             
                break;
                
            }
        }
            if (!foundssn) {
                System.out.println("SSN not found");
            }

        }


    public static void receiveOrder(int identifier, String DateIdentifier) {
        boolean foundssn = false;
        boolean founddate = false;
        Customer myCustomer = new  Customer();

        for (Customer value : PopulateData.customer) {
            if (value.getSsn() == identifier) {
                foundssn = true;
                for (Booking val : value.bookings) {
                    if (val.getBookingDate().equals(DateIdentifier)) {
                    	myCustomer = value;
                        founddate = true;
                        break;
                    }
                }
            }
        }
        if ((foundssn) && (founddate)) {
            Scanner order = new Scanner(System.in);
            System.out.println("Please enter details: ");
            String details = order.next();
            System.out.println("Please enter description: ");
            String description = order.next();
            for (Booking value : myCustomer.bookings) {
                if (value.getBookingDate().equals(DateIdentifier)) {
                    value.makeOrder(details,description);
                    break;
                }
            }
        }
        if (!foundssn) {
            System.out.println("SSN not found");
        }
        if (!founddate) {
            System.out.println("Date not found");
        }

    }

    public static void receiveBooking(int identifier) {
        boolean foundssn = false;
        for (Customer value : PopulateData.customer) {
            if (value.getSsn() == identifier) {
                foundssn = true;
                break;
            }
        }
        if (foundssn) {
            Scanner book = new Scanner(System.in);
            System.out.println("Please enter table number: ");
            int bookingtable = book.nextInt();
            System.out.println("Please enter booking date: ");
            String bookingDate = book.next();
          //  SimpleDateFormat bookingDate = new SimpleDateFormat ( ("yyyy-MM-dd"));

            for (Customer value : PopulateData.customer) {
                if (value.getSsn() == identifier) {
                    value.makeBooking(bookingtable,bookingDate);
                    break;
                }
            }
        }
        if (!foundssn) {
            System.out.println("SSN not found");
        }


    }

    public static void customerdetails(int y) {
        boolean foundssn = false;
        for (Customer value : PopulateData.customer) {
            if (value.ssn == y) {
                foundssn = true;
                System.out.println(value.getName());
                System.out.println(value.getSsn());
                System.out.println(value.getGender());
                System.out.println(value.getDateOfBirth());
                System.out.println(value.getRegistrationDate());
            }
        }
        if (!foundssn) {
            System.out.println("SSN not found");
        }
    }

    public static void deleteCustomer(int y) {
        boolean foundssn = false;
        Customer myCustomer = new  Customer();
        Booking myBooking = new Booking();
        int count = -1;
        for (Customer value : PopulateData.customer) {
            count++;
            if (value.getSsn() == y) {
                foundssn = true;
                myCustomer = value;
                break;
            }
        }
        if (foundssn) {
            PopulateData.customer.remove(count);
            if (count< myCustomer.bookings.size()) {
            	myCustomer.bookings.remove(count);}
            if (count< myBooking.orders.size()) {
            myBooking.orders.remove(count);}
        }


        if (!foundssn) {
            System.out.println("SSN not found");
        }
    }
    public static void getStaffDetails(int identifier) {
        boolean foundssn=false;
        for (Staff value : PopulateData.staff) {
            if (value.getSsn() == identifier) {
                System.out.println("Name of staff member is " + value.getName() +
                        " gender is " + value.getGender()+ "date of birth is "+ value.getDateOfBirth());
                foundssn=true;
                break;
            }

        }
        if (!foundssn) {
            System.out.println("SSN not found");
        }

    }
    public static void deleteStaff(int y) {
        boolean foundssn = false;
        for (int i = 0; i < PopulateData.staff.size(); i++) {
            if (PopulateData.staff.get(i).ssn == y) {
                foundssn = true;
                PopulateData.staff.remove(i);
                break;
            }
        }
        if (!foundssn) {
            System.out.println("SSN not found");
        }

    }

    public static void addCustomer() {
        boolean repeat = true;
        while (repeat) {
            System.out.println("---Adding a Customer---");
            System.out.println("Please enter ssn: ");
            Scanner add = new Scanner(System.in);
            int ssn = add.nextInt();
            System.out.println("Please enter name: ");
            String name = add.next();
            System.out.println("Please enter gender: ");
            Character gender = add.next().charAt(0);
            System.out.println("Please enter DOB: ");
            String DOB = add.next();
            System.out.println("Please enter registration date: ");
            String DOR = add.next();

            Customer pop = new Customer();
            pop.setName(name);
            pop.setSsn(ssn);
            pop.setGender(gender);
            pop.setRegistrationDate(DOR);
            pop.setDateOfBirth(DOB);
            PopulateData.customer.add(pop);
            System.out.println("Would you like to add another customer entry(Y/N)?: ");
            char opt = add.next().charAt(0);
            if (opt == 'Y') {
                System.out.println("---Adding another Staff Entry---");
                repeat = true;
            }
            else repeat = false;
        }
    }
    public static void addStaff() {
        boolean repeat = true;
        while (repeat) {
            System.out.println("Please enter ssn: ");
            Scanner add = new Scanner(System.in);
            int ssn = add.nextInt();
            System.out.println("Please enter name:  ");
            String name = add.next();
            System.out.println("Please enter gender: ");
            Character gender = add.next().charAt(0);
            System.out.println("Please enter Date of Birth: ");
            String dateOfBirth = add.next();
            Staff pop = new Staff();
            pop.setName(name);
            pop.setSsn(ssn);
            pop.setGender(gender);
            pop.setDateOfBirth(dateOfBirth);
            PopulateData.staff.add(pop);
            System.out.println("Would you like to delete another Staff Entry(Y/N)?: ");
            char opt = add.next().charAt(0);
            if (opt == 'Y') {
                System.out.println("---Adding another Staff Entry---");
                repeat = true;
            }
            else repeat = false;
        }
    }



}
