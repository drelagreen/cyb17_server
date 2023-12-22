/*
 * Railway Station API
 * API for managing railway stations, parks, ways, locomotives, and wagons.
 *
 * The version of the OpenAPI document: 1.0.0
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package org.openapitools.client.api;

import org.openapitools.client.ApiException;
import org.openapitools.client.model.Park;
import org.openapitools.client.model.Station;
import org.openapitools.client.model.StationShort;
import org.openapitools.client.model.Way;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for DefaultApi
 */
@Disabled
public class DefaultApiTest {

    private final DefaultApi api = new DefaultApi();

    /**
     * Get information about a specific park
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void parkIdGetTest() throws ApiException {
        Integer id = null;
        Park response = api.parkIdGet(id);
        // TODO: test validations
    }

    /**
     * Hello World!
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void rootGetTest() throws ApiException {
        String response = api.rootGet();
        // TODO: test validations
    }

    /**
     * Get a list of stations
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void stationsGetTest() throws ApiException {
        List<StationShort> response = api.stationsGet();
        // TODO: test validations
    }

    /**
     * Get information about a specific station
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void stationsIdGetTest() throws ApiException {
        Integer id = null;
        Station response = api.stationsIdGet(id);
        // TODO: test validations
    }

    /**
     * Get information about a specific way
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void wayIdGetTest() throws ApiException {
        Integer id = null;
        Way response = api.wayIdGet(id);
        // TODO: test validations
    }

}