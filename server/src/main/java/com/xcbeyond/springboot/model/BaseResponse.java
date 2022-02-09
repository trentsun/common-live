package com.xcbeyond.springboot.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BaseResponse<T> {
    @JsonProperty(value = "success")
    public Boolean success = true;
    @JsonProperty(value = "data")
    public T data;
    @JsonProperty(value = "code")
    public int code = 0;
    @JsonProperty(value = "errorMsg")
    public String errorMsg = "";

    @Override
    public String toString() {
        return "{" +
                "success:" + success +
                ", data:" + data +
                ", code:" + code +
                ", errorMsg:'" + errorMsg + '\'' +
                '}';
    }
}