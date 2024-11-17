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
public class Channel {

    private String channelType;
    private String details;

    public Channel(String channelType, String details) {
        this.channelType = channelType;
        this.details = details;
    }


    public String getChannelType() {
        return channelType;
    }


    public void setChannelType(String channelType) {
        this.channelType = channelType;
    }


    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    @Override
    public String toString() {
        return "Channel Type: " + channelType + ", Details: " + details;
    }
}