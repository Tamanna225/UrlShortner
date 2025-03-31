package com.shrtcut.shrtcut.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Value;

//@Value //bss setter ke bina same same thing as data and also makes the object immutable
//might need to make it mutable so uncomment the below lines and comment the above one
//@Getter
//@AllArgsConstructor
@NoArgsConstructor
public class UrlResponseDto {
       private String shortUrl;

       public UrlResponseDto(String shortUrl) {
              this.shortUrl = shortUrl;
       }
       public String getShortUrl() {
              return shortUrl;
       }


}
