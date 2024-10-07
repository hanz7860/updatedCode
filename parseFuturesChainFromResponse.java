// private FuturesChain parseFuturesChainFromResponse(String response) {
//     FuturesChain futuresChain = new FuturesChain();
//     List<String> dates = new ArrayList<>();
//     List<Double> midRates = new ArrayList<>();
//
//     try {
//         DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
//         DocumentBuilder builder = factory.newDocumentBuilder();
//         Document doc = builder.parse(new InputSource(new StringReader(response)));
//
//         // Call the method to parse contract
//         String contract = parseContractFromResponse(response);
//         futuresChain.setContract(contract);
//
//         // Parsing other elements
//         futuresChain.setName(doc.getElementsByTagName("name").item(0).getTextContent());
//
//         NodeList quoteNodes = doc.getElementsByTagName("Quote");
//         for (int i = 0; i < quoteNodes.getLength(); i++) {
//             Element quoteElement = (Element) quoteNodes.item(i);
//             dates.add(quoteElement.getAttribute("date"));
//             midRates.add(Double.parseDouble(quoteElement.getAttribute("midRate")));
//         }
//
//         futuresChain.setDates(dates);
//         futuresChain.setMidRates(midRates);
//
//     } catch (Exception e) {
//         e.printStackTrace();
//     }
//
//     return futuresChain;
// }


private FuturesChain parseFuturesChainFromResponse(String response) {
    FuturesChain futuresChain = new FuturesChain();

    try {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(new InputSource(new StringReader(response)));
        NodeList futuresChainNodes = doc.getElementsByTagName("FuturesChain");

        if (futuresChainNodes.getLength() > 0) {
            Element futuresChainElement = (Element) futuresChainNodes.item(0);

            // Set the basic fields
            futuresChain.setContract(futuresChainElement.getAttribute("contract"));
            futuresChain.setName(futuresChainElement.getAttribute("name"));
            futuresChain.setBusinessDate(futuresChainElement.getAttribute("businessDate"));
            futuresChain.setLocation(futuresChainElement.getAttribute("location"));
            futuresChain.setMarketTime(futuresChainElement.getAttribute("marketTime"));

            // Extract <Quote> elements
            NodeList quoteNodes = futuresChainElement.getElementsByTagName("Quote");
            for (int i = 0; i < quoteNodes.getLength(); i++) {
                Element quoteElement = (Element) quoteNodes.item(i);

                String date = quoteElement.getAttribute("date");
                Double midRate = Double.parseDouble(quoteElement.getAttribute("midRate"));

                // Store date, midRate as key-value pairs
                futuresChain.addDateMidRatePair(date, midRate);
            }
        }

    } catch (Exception e) {
        e.printStackTrace();
    }

    return futuresChain;
}
