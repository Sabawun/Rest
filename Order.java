public class Order {
    public String details;
    public String description;


    public void setDescription(String description) {
        this.description = description;
    }
    public void setDetails(String details) {
        this.details = details;
    }

    public String getDetails() {
        return details;
    }


    public String getDescription() {
        return description;
    }

    public Order() {
    }

    public Order(String details, String description) {
        this.details = details;
        this.description = description;
    }
}
