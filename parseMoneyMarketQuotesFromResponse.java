// private MoneyMarketQuotes parseMoneyMarketQuotesFromResponse(String response) {
//     MoneyMarketQuotes moneyMarketQuotes = new MoneyMarketQuotes();
//     List<String> tenors = new ArrayList<>();
//     List<Double> midRates = new ArrayList<>();
//     List<Double> spreads = new ArrayList<>();
//
//     try {
//         DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
//         DocumentBuilder builder = factory.newDocumentBuilder();
//         Document doc = builder.parse(new InputSource(new StringReader(response)));
//
//         moneyMarketQuotes.setRateFixingIndex(doc.getElementsByTagName("rateFixingIndex").item(0).getTextContent());
//         moneyMarketQuotes.setName(doc.getElementsByTagName("name").item(0).getTextContent());
//         moneyMarketQuotes.setCcy(doc.getElementsByTagName("ccy").item(0).getTextContent());
//         moneyMarketQuotes.setBusinessDate(doc.getElementsByTagName("businessDate").item(0).getTextContent());
//         moneyMarketQuotes.setLocation(doc.getElementsByTagName("location").item(0).getTextContent());
//         moneyMarketQuotes.setMarketTime(doc.getElementsByTagName("marketTime").item(0).getTextContent());
//
//         NodeList quoteNodes = doc.getElementsByTagName("Quote");
//         for (int i = 0; i < quoteNodes.getLength(); i++) {
//             Element quoteElement = (Element) quoteNodes.item(i);
//             tenors.add(quoteElement.getAttribute("tenor"));
//             midRates.add(Double.parseDouble(quoteElement.getAttribute("midRate")));
//             spreads.add(Double.parseDouble(quoteElement.getAttribute("spread")));
//         }
//
//         moneyMarketQuotes.setTenors(tenors);
//         moneyMarketQuotes.setMidRates(midRates);
//         moneyMarketQuotes.setSpreads(spreads);
//
//     } catch (Exception e) {
//         e.printStackTrace();
//     }
//
//     return moneyMarketQuotes;
// }


private MoneyMarketQuotes parseMoneyMarketQuotesFromResponse(String response) {
    MoneyMarketQuotes moneyMarketQuotes = new MoneyMarketQuotes();

    try {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(new InputSource(new StringReader(response)));

        NodeList moneyMarketQuotesNodes = doc.getElementsByTagName("MoneyMarketQuotes");
        if (moneyMarketQuotesNodes.getLength() > 0) {
            Element moneyMarketQuotesElement = (Element) moneyMarketQuotesNodes.item(0);

            moneyMarketQuotes.setRateFixingIndex(moneyMarketQuotesElement.getAttribute("rateFixingIndex"));
            moneyMarketQuotes.setName(moneyMarketQuotesElement.getAttribute("name"));
            moneyMarketQuotes.setCcy(moneyMarketQuotesElement.getAttribute("ccy"));
            moneyMarketQuotes.setBusinessDate(moneyMarketQuotesElement.getAttribute("businessDate"));
            moneyMarketQuotes.setLocation(moneyMarketQuotesElement.getAttribute("location"));
            moneyMarketQuotes.setMarketTime(moneyMarketQuotesElement.getAttribute("marketTime"));

            NodeList quoteNodes = moneyMarketQuotesElement.getElementsByTagName("Quote");
            for (int i = 0; i < quoteNodes.getLength(); i++) {
                Element quoteElement = (Element) quoteNodes.item(i);
                String tenor = quoteElement.getAttribute("tenor");
                Double midRate = Double.parseDouble(quoteElement.getAttribute("midRate"));
                Double spread = Double.parseDouble(quoteElement.getAttribute("spread"));

                // Add combined details [tenor, midRate, spread] to MoneyMarketQuotes
                moneyMarketQuotes.addQuoteDetail(tenor, midRate, spread);
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
    }

    return moneyMarketQuotes;
}
