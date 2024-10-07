// Updated TurnOfYearSpread.java
public class TurnOfYearSpread {
    private String rateFixingIndex;
    private String name;
    private String ccy;
    private String businessDate;
    private String location;
    private String marketTime;
    private List<List<String>> dateSpreadDetails; // Holds [startDate, endDate, spread] for each entry

    // Constructors, getters, and setters
    public TurnOfYearSpread() {
        this.dateSpreadDetails = new ArrayList<>();
    }

    public void addDateSpreadDetail(String startDate, String endDate, Double spread) {
        List<String> entry = new ArrayList<>();
        entry.add(startDate);
        entry.add(endDate);
        entry.add(spread.toString());
        this.dateSpreadDetails.add(entry);
    }

    public List<List<String>> getDateSpreadDetails() {
        return dateSpreadDetails;
    }

    public void setDateSpreadDetails(List<List<String>> dateSpreadDetails) {
        this.dateSpreadDetails = dateSpreadDetails;
    }
}
