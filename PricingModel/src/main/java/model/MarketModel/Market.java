/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.MarketModel;

import java.util.ArrayList;
import model.ProductManagement.SolutionOffer;

/**
 *
 * @author kal bugrara
 */
public class Market {

    private ArrayList<SolutionOffer> solutionOffers;
    private ArrayList<MarketChannelAssignment> channels;
    private ArrayList<String> characteristics;
    private ArrayList<Market> submarkets;
    private String marketId;
    private int size;

    public Market(String marketId) {
        this.marketId = marketId;
        this.characteristics = new ArrayList<>();
        this.solutionOffers = new ArrayList<>();
        this.channels = new ArrayList<>();
        this.submarkets = new ArrayList<>();
    }

    // Getters and setters
    public String getMarketId() {
        return marketId;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    // Methods for managing characteristics
    public void addCharacteristic(String characteristic) {
        characteristics.add(characteristic);
    }

    public ArrayList<String> getCharacteristics() {
        return characteristics;
    }

    // Methods for managing SolutionOffers
    public void addSolutionOffer(SolutionOffer offer) {
        solutionOffers.add(offer);
    }

    public ArrayList<SolutionOffer> getSolutionOffers() {
        return solutionOffers;
    }

    // Methods for managing MarketChannelAssignments
    public void addChannel(MarketChannelAssignment channel) {
        channels.add(channel);
    }

    public ArrayList<MarketChannelAssignment> getChannels() {
        return channels;
    }

    // Methods for managing submarkets
    public void addSubmarket(Market submarket) {
        submarkets.add(submarket);
    }

    public ArrayList<Market> getSubmarkets() {
        return submarkets;
    }

    @Override
    public String toString() {
        return "Market ID: " + marketId + ", Size: " + size + ", Characteristics: " + characteristics;
    }
}