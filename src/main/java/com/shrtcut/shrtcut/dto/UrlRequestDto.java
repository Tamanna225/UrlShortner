package com.shrtcut.shrtcut.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data   //contains everything getter, setter, tostring, requiredargsconstructor. All in one hai
//@Getter
//@Setter
public class UrlRequestDto {
    @NotBlank(message = "Long URL cannot be empty")
    private String longUrl;

    private String shortCode;


    public String getLongUrl() {
        return longUrl;
    }

    public void setLongUrl(String longUrl) {
        this.longUrl = longUrl;
    }

    public String getShortCode() {
        return shortCode;
    }

    public void setShortCode(String shortCode) {
        this.shortCode = shortCode;
    }
}
