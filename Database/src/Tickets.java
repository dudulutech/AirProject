import java.sql.Date;

public class Tickets {
    private Long id;
    private String fromAddress;
    private String toAddress;
    private String goDate;
    private String arriveDate;


    public Tickets(){

    }

    public Tickets(Long id, String fromAddress, String toAddress, String goDate, String arriveDate) {
        this.id = id;
        this.fromAddress = fromAddress;
        this.toAddress = toAddress;
        this.goDate = goDate;
        this.arriveDate = arriveDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFromAddress() {
        return fromAddress;
    }

    public void setFromAddress(String fromAddress) {
        this.fromAddress = fromAddress;
    }

    public String getToAddress() {
        return toAddress;
    }

    public void setToAddress(String toAddress) {
        this.toAddress = toAddress;
    }

    public String getGoDate() {
        return goDate;
    }

    public void setGoDate(String goDate) {
        this.goDate = goDate;
    }

    public String getArriveDate() {
        return arriveDate;
    }

    public void setArriveDate(String arriveDate) {
        this.arriveDate = arriveDate;
    }
}
