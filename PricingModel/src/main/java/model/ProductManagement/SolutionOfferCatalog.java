/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.ProductManagement;

import java.util.ArrayList;
import model.MarketModel.MarketChannelAssignment;

/**
 *
 * @author kal bugrara
 */
public class SolutionOfferCatalog {
    private ArrayList<SolutionOffer> solutionOffers;

    public SolutionOfferCatalog() {
        solutionOffers = new ArrayList<>();
    }
    public void addSolutionOffer(SolutionOffer solutionOffer) {
        solutionOffers.add(solutionOffer);
    }

    public ArrayList<SolutionOffer> getSolutionOffers() {
        return solutionOffers;
    }

    public SolutionOffer findSolutionOfferByMarketChannel(MarketChannelAssignment marketChannelAssignment) {
        for (SolutionOffer offer : solutionOffers) {
            if (offer.getMarketChannelAssignment().equals(marketChannelAssignment)) {
                return offer;
            }
        }
        return null;
    }


    public void clearCatalog() {
        solutionOffers.clear();
    }

}