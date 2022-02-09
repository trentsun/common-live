package com.xcbeyond.springboot.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Room implements Serializable {
    @JsonProperty(value = "id")
    public String id;
    @JsonProperty(value = "platform")
    public String platform;
    @JsonProperty(value = "isReplay")
    public boolean isReplay;
    @JsonProperty(value = "live_url")
    public String live_url;
    @JsonProperty(value = "name")
    public String name;

    @Override
    public String toString() {
        return "Room{" +
                "id='" + id + '\'' +
                ", platform='" + platform + '\'' +
                ", isReplay=" + isReplay +
                ", live_url='" + live_url + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}