//import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class PopulateData {
    static ArrayList<Staff> staff = new ArrayList<>();
    static ArrayList<Customer> customer = new ArrayList<>();


    public static void populate() {
        for (int i = 0; i < 3; i++) {
            Staff pop = new Staff();
            pop.setName("Waiter" + i);
            pop.setSsn(1110 + i);
            pop.setGender('M');
            pop.setDateOfBirth("1998-02-12");
            PopulateData.staff.add(pop);
        }
        for (int i=0;i<3;i++) {
            Customer pop = new Customer();
            int x = 123;
            String y = "111";    
            pop.setName("Customer"+i);
            pop.setSsn(1110+i);
            pop.setGender('F');
            pop.setRegistrationDate("2020-11-11");
            pop.setDateOfBirth("1998-01-12");
            pop.makeBooking(x,y);
            pop.getBooking().get(0).makeOrder("This", "Works");
            PopulateData.customer.add(pop);
        }

            }
        }
