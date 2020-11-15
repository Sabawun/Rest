//import java.text.SimpleDateFormat;

public class Staff {
        public int ssn;
        public String name;
        public Character Gender;
        public String DateOfBirth;


    public void setName(String name) {
        this.name = name;
    }

    public void setGender(Character gender) {
        Gender = gender;
    }

    public void setDateOfBirth(String dateOfBirth) {
        DateOfBirth = dateOfBirth;
    }

    public void setSsn(int ssn) {
        this.ssn = ssn;
    }


    public String getName() {
        return name;
    }

    public Character getGender() {
        return Gender;
    }

    public String getDateOfBirth() {

        return this.DateOfBirth;
    }

    public int getSsn() {
        return ssn;
    }

    public Staff(int ssn ) {
        this.ssn = ssn;
    }

    public Staff(int ssn ,String name, Character Gender) {
        this.ssn = ssn;
        this.name = name;
        this.Gender = Gender;
    }
    public Staff() {

    }

}
