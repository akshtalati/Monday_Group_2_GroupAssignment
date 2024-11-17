/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.CustomerManagement;

import java.util.ArrayList;
import model.MarketModel.Market;
/**
 *
 * @author kal bugrara
 */
public class MarketCatalog {

    private ArrayList<Market> markets;

    public MarketCatalog() {
        markets = new ArrayList<>();
    }

    /**
     * Adds a new market to the catalog.
     * @param market The market to be added.
     */
    public void addMarket(Market market) {
        markets.add(market);
    }

    /**
     * Removes a market from the catalog based on the market ID.
     * @param marketId The ID of the market to be removed.
     * @return true if the market was removed, false if not found.
     */
    public boolean removeMarket(String marketId) {
        for (Market market : markets) {
            if (market.getMarketId().equals(marketId)) {
                markets.remove(market);
                return true;
            }
        }
        return false; // Market not found
    }

    /**
     * Retrieves a market by its ID.
     * @param marketId The ID of the market to retrieve.
     * @return The Market object if found, null otherwise.
     */
    public Market findMarketById(String marketId) {
        for (Market market : markets) {
            if (market.getMarketId().equals(marketId)) {
                return market;
            }
        }
        return null; // Market not found
    }

    /**
     * Retrieves the list of all markets in the catalog.
     * @return The list of markets.
     */
    public ArrayList<Market> getAllMarkets() {
        return markets;
    }

    /**
     * Provides the total number of markets in the catalog.
     * @return The count of markets.
     */
    public int getMarketCount() {
        return markets.size();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Market Catalog:\n");
        for (Market market : markets) {
            sb.append(market.toString()).append("\n");
        }
        return sb.toString();
    }
}