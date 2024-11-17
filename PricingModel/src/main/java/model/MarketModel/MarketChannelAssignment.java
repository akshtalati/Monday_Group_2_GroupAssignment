/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.MarketModel;

/**
 *
 * @author kal bugrara
 */
public class MarketChannelAssignment {

    private Market market;
    private Channel channel;

    public MarketChannelAssignment(Market market, Channel channel) {
        this.market = market;
        this.channel = channel;
    }

    public Market getMarket() {
        return market;
    }

    public void setMarket(Market market) {
        this.market = market;
    }

    public Channel getChannel() {
        return channel;
    }

    public void setChannel(Channel channel) {
        this.channel = channel;
    }

    @Override
    public String toString() {
        return "MarketChannelAssignment [Market: " + market + ", Channel: " + channel + "]";
    }
}
