public class FuturesChain {
    private String contract;
    private String name;
    private String businessDate;
    private String location;
    private String marketTime;
    private List<Map<String, Double>> dateMidRatePairs;  // Store pairs of date and midRate

    // Constructors, getters, setters

    public FuturesChain() {
        this.dateMidRatePairs = new ArrayList<>();
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

    public List<Map<String, Double>> getDateMidRatePairs() {
        return dateMidRatePairs;
    }

    public void setDateMidRatePairs(List<Map<String, Double>> dateMidRatePairs) {
        this.dateMidRatePairs = dateMidRatePairs;
    }

    public void addDateMidRatePair(String date, Double midRate) {
        Map<String, Double> pair = new HashMap<>();
        pair.put(date, midRate);
        this.dateMidRatePairs.add(pair);
    }
}
