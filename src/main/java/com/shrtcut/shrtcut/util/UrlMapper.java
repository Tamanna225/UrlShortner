package com.shrtcut.shrtcut.util;

import com.shrtcut.shrtcut.dto.UrlResponseDto;
import com.shrtcut.shrtcut.model.UrlMapping;

public class UrlMapper {
    public static UrlResponseDto toDto(UrlMapping urlMapping) {
        return new UrlResponseDto("https://urlshortner-0h6z.onrender.com/r/" + urlMapping.getShortCode());
    }
}
