public class RateForward {
    private String rateFixingIndex;
    private String rateType;
    private String name;
    private String ccy;
    private String businessDate;
    private String location;
    private String marketTime;
    private List<List<String>> forwardDetails; // Holds [startDate, endDate, midRate, spread]

    // Constructors, getters, and setters
    public RateForward() {
        this.forwardDetails = new ArrayList<>();
    }

    public void addForwardDetail(String startDate, String endDate, Double midRate, Double spread) {
        List<String> entry = new ArrayList<>();
        entry.add(startDate);
        entry.add(endDate);
        entry.add(midRate.toString());
        entry.add(spread.toString());
        this.forwardDetails.add(entry);
    }

    public List<List<String>> getForwardDetails() {
        return forwardDetails;
    }

    public void setForwardDetails(List<List<String>> forwardDetails) {
        this.forwardDetails = forwardDetails;
    }
}
