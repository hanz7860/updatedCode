public class MoneyMarketQuotes {
    private String rateFixingIndex;
    private String name;
    private String ccy;
    private String businessDate;
    private String location;
    private String marketTime;
    private List<List<String>> quoteDetails; // Holds [tenor, midRate, spread] for each entry

    // Constructors, getters, and setters
    public MoneyMarketQuotes() {
        this.quoteDetails = new ArrayList<>();
    }

    public void addQuoteDetail(String tenor, Double midRate, Double spread) {
        List<String> entry = new ArrayList<>();
        entry.add(tenor);
        entry.add(midRate.toString());
        entry.add(spread.toString());
        this.quoteDetails.add(entry);
    }

    public List<List<String>> getQuoteDetails() {
        return quoteDetails;
    }

    public void setQuoteDetails(List<List<String>> quoteDetails) {
        this.quoteDetails = quoteDetails;
    }
}
