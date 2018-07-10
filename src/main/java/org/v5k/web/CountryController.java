package org.v5k.web;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.v5k.service.CountryService;

import javax.annotation.Resource;

@Controller
public class CountryController {

    @Resource
    private CountryService countryService;

    @GetMapping(value = "/country/{code}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String country(@PathVariable String code) {
        return countryService.getCountry(code);
    }

}
