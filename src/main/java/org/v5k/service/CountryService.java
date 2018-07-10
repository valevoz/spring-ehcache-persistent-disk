package org.v5k.service;

import org.springframework.stereotype.Service;

import javax.cache.annotation.CacheResult;

import static org.v5k.config.CacheConfig.COUNTRY;

@Service
public class CountryService {

    @CacheResult(cacheName = COUNTRY)
    public String getCountry(String code) {
        switch (code.toUpperCase()) {
            case "US":
                return "United States of America";
            case "CA":
                return "Canada";
            case "MX":
                return "Mexico";
            default:
                return String.format("No country found by code '%s'", code);
        }
    }
}
