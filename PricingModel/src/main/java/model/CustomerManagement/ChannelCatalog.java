/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.CustomerManagement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kal bugrara
 */
public class ChannelCatalog {

    // List to store channels
    private List<Channel> channels;

    // Constructor
    public ChannelCatalog() {
        channels = new ArrayList<>();
    }

    // Method to add a new channel
    public void addChannel(String name, String type) {
        Channel channel = new Channel(name, type);
        channels.add(channel);
    }

    // Method to update an existing channel by name
    public boolean updateChannel(String name, String newType) {
        for (Channel channel : channels) {
            if (channel.getName().equals(name)) {
                channel.setType(newType);
                return true;
            }
        }
        return false; // Channel not found
    }

    // Method to retrieve a channel by name
    public Channel getChannel(String name) {
        for (Channel channel : channels) {
            if (channel.getName().equals(name)) {
                return channel;
            }
        }
        return null; // Channel not found
    }

    // Method to retrieve all channels
    public List<Channel> getAllChannels() {
        return channels;
    }

    // Inner class to represent individual channels
    public class Channel {
        private String name;
        private String type;

        public Channel(String name, String type) {
            this.name = name;
            this.type = type;
        }

        public String getName() {
            return name;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        @Override
        public String toString() {
            return "Channel{name='" + name + "', type='" + type + "'}";
        }
    }
}
