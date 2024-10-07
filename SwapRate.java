public class SwapRate {
    private String location;
    private String marketTime;
    private String currency;
    private String rateFixingIndex;
    private String indexTerm;
    private String name;
    private List<List<String>> rateDetails; // Holds [term, midRate, spread]

    // Constructors
    public SwapRate() {
        this.rateDetails = new ArrayList<>();
    }

    public SwapRate(String location, String marketTime, String currency, String rateFixingIndex,
                    String indexTerm, String name) {
        this.location = location;
        this.marketTime = marketTime;
        this.currency = currency;
        this.rateFixingIndex = rateFixingIndex;
        this.indexTerm = indexTerm;
        this.name = name;
        this.rateDetails = new ArrayList<>();
    }

    // Method to add rate details (term, midRate, spread)
    public void addRateDetail(String term, Double midRate, Double spread) {
        List<String> entry = new ArrayList<>();
        entry.add(term);
        entry.add(midRate.toString());
        entry.add(spread.toString());
        this.rateDetails.add(entry);
    }

    // Getters and Setters
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

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getRateFixingIndex() {
        return rateFixingIndex;
    }

    public void setRateFixingIndex(String rateFixingIndex) {
        this.rateFixingIndex = rateFixingIndex;
    }

    public String getIndexTerm() {
        return indexTerm;
    }

    public void setIndexTerm(String indexTerm) {
        this.indexTerm = indexTerm;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<List<String>> getRateDetails() {
        return rateDetails;
    }

    public void setRateDetails(List<List<String>> rateDetails) {
        this.rateDetails = rateDetails;
    }
}
