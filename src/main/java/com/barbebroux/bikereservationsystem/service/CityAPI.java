package com.barbebroux.bikereservationsystem.service;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.io.InputStream;
import java.io.UncheckedIOException;
import java.util.List;
import java.util.Objects;

@Service
public class CityAPI {

    public static final String ZIP_API = "http://api.zippopotam.us/FR/";
    public static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    public static List<ZipCode> toList(InputStream inputStream) {
        try {
            return OBJECT_MAPPER.readValue(inputStream, new TypeReference<>() {});
        } catch (IOException e) {
            throw new UncheckedIOException(e.getMessage(), e);
        }
    }

    public static ZipCode toObject(InputStream inputStream) {
        try {
            return OBJECT_MAPPER.readValue(inputStream, ZipCode.class);
        }
        catch (IOException exc) {
            throw new UncheckedIOException(exc);
        }
    }

    public static String toJson(ZipCode zipCode) {
        try {
            return OBJECT_MAPPER.writeValueAsString(zipCode);
        }
        catch (JsonProcessingException exc) {
            throw new UncheckedIOException(exc);
        }
    }

    public String getCityByZipCode(String zipCode) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<ZipCode> responseEntity = restTemplate.getForEntity(ZIP_API + zipCode, ZipCode.class);

        HttpStatusCode statusCode = responseEntity.getStatusCode();

        ZipCode zipCode1 = Objects.requireNonNull(responseEntity.getBody());

        return zipCode1.places.get(0).placeName();
    }







    public record ZipCode(@JsonProperty("post code")String postCode, String country, @JsonProperty("country abbreviation")String countryAbbreviation, List<Place> places) {}

    public record Place(@JsonProperty("place name")String placeName, String longitude, String state, @JsonProperty("state abbreviation")String stateAbbreviation, String latitude) {}

}
