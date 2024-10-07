import java.util.ArrayList;
import java.util.List;

public class FuturesChain {
    private String contract;
    private String name;
    private String businessDate;
    private String location;
    private String marketTime;
    private List<List<String>> dateMidRateDetails; // Holds [date, midRate]

    // Constructors, getters, and setters
    public FuturesChain() {
        this.dateMidRateDetails = new ArrayList<>();
    }

    public void addDateMidRateDetail(String date, Double midRate) {
        List<String> entry = new ArrayList<>();
        entry.add(date);
        entry.add(midRate.toString());
        this.dateMidRateDetails.add(entry);
    }

    public List<List<String>> getDateMidRateDetails() {
        return dateMidRateDetails;
    }

    public void setDateMidRateDetails(List<List<String>> dateMidRateDetails) {
        this.dateMidRateDetails = dateMidRateDetails;
    }

    public String getContract() {
        return contract;
    }

    public void setContract(String contract) {
        this.contract = contract;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBusinessDate() {
        return businessDate;
    }

    public void setBusinessDate(String businessDate) {
        this.businessDate = businessDate;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getMarketTime() {
        return marketTime;
    }

    public void setMarketTime(String marketTime) {
        this.marketTime = marketTime;
    }
}
