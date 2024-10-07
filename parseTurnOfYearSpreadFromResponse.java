// private TurnOfYearSpread parseTurnOfYearSpreadFromResponse(String response) {
//     TurnOfYearSpread turnOfYearSpread = new TurnOfYearSpread();
//     List<String> startDates = new ArrayList<>();
//     List<String> endDates = new ArrayList<>();
//     List<Double> spreads = new ArrayList<>();
//
//     try {
//         DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
//         DocumentBuilder builder = factory.newDocumentBuilder();
//         Document doc = builder.parse(new InputSource(new StringReader(response)));
//
//         turnOfYearSpread.setRateFixingIndex(doc.getElementsByTagName("rateFixingIndex").item(0).getTextContent());
//         turnOfYearSpread.setName(doc.getElementsByTagName("name").item(0).getTextContent());
//         turnOfYearSpread.setCcy(doc.getElementsByTagName("ccy").item(0).getTextContent());
//         turnOfYearSpread.setBusinessDate(doc.getElementsByTagName("businessDate").item(0).getTextContent());
//         turnOfYearSpread.setLocation(doc.getElementsByTagName("location").item(0).getTextContent());
//         turnOfYearSpread.setMarketTime(doc.getElementsByTagName("marketTime").item(0).getTextContent());
//
//         NodeList quoteNodes = doc.getElementsByTagName("Quote");
//         for (int i = 0; i < quoteNodes.getLength(); i++) {
//             Element quoteElement = (Element) quoteNodes.item(i);
//             startDates.add(quoteElement.getAttribute("startDate"));
//             endDates.add(quoteElement.getAttribute("endDate"));
//             spreads.add(Double.parseDouble(quoteElement.getAttribute("spread")));
//         }
//
//         turnOfYearSpread.setStartDates(startDates);
//         turnOfYearSpread.setEndDates(endDates);
//         turnOfYearSpread.setSpreads(spreads);
//
//     } catch (Exception e) {
//         e.printStackTrace();
//     }
//
//     return turnOfYearSpread;
// }


private TurnOfYearSpread parseTurnOfYearSpreadFromResponse(String response) {
    TurnOfYearSpread turnOfYearSpread = new TurnOfYearSpread();

    try {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(new InputSource(new StringReader(response)));

        NodeList turnOfYearSpreadNodes = doc.getElementsByTagName("TurnOfYearSpread");
        if (turnOfYearSpreadNodes.getLength() > 0) {
            Element turnOfYearSpreadElement = (Element) turnOfYearSpreadNodes.item(0);

            turnOfYearSpread.setRateFixingIndex(turnOfYearSpreadElement.getAttribute("rateFixingIndex"));
            turnOfYearSpread.setName(turnOfYearSpreadElement.getAttribute("name"));
            turnOfYearSpread.setCcy(turnOfYearSpreadElement.getAttribute("ccy"));
            turnOfYearSpread.setBusinessDate(turnOfYearSpreadElement.getAttribute("businessDate"));
            turnOfYearSpread.setLocation(turnOfYearSpreadElement.getAttribute("location"));
            turnOfYearSpread.setMarketTime(turnOfYearSpreadElement.getAttribute("marketTime"));

            NodeList quoteNodes = turnOfYearSpreadElement.getElementsByTagName("Quote");
            for (int i = 0; i < quoteNodes.getLength(); i++) {
                Element quoteElement = (Element) quoteNodes.item(i);
                String startDate = quoteElement.getAttribute("startDate");
                String endDate = quoteElement.getAttribute("endDate");
                Double spread = Double.parseDouble(quoteElement.getAttribute("spread"));

                // Add combined details [startDate, endDate, spread] to the TurnOfYearSpread object
                turnOfYearSpread.addDateSpreadDetail(startDate, endDate, spread);
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
    }

    return turnOfYearSpread;
}
