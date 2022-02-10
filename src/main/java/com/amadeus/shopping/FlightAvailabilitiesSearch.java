package com.amadeus.shopping;

import com.amadeus.Amadeus;
import com.amadeus.Params;
import com.amadeus.Response;
import com.amadeus.exceptions.ResponseException;
import com.amadeus.resources.FlightAvailabilitySearch;
import com.amadeus.resources.Resource;
import com.google.gson.JsonObject;

/**
 * <p>
 * A namespaced client for the
 * <code>/v1/shopping/availability/flight-availabilities</code> endpoints.
 * </p>
 *
 * <p>
 * Access via the Amadeus client object.
 * </p>
 *
 * <pre>
 * Amadeus amadeus = Amadeus.builder(API_KEY, API_SECRET).build();
 * amadeus.shopping.flightAvailabilitiesSearch;</pre>
 */
public class FlightAvailabilitiesSearch {
	private Amadeus client;
	
	/**
	 * Constructor.
	 *
	 * @hide
	 */
	public FlightAvailabilitiesSearch(Amadeus client) {
		this.client = client;
	}
	
	/**
	 * <p>
	 *   The Amadeus Flight Availability API provides a list of flights with seats for sale,
	 *   and the quantity of seats available in different fare classes on a given itinerary.
	 *   Additional information such as carrier and aircraft information,
	 *   the departure and arrival terminals, schedule, and route are also provided.
	 * </p>
	 *
	 * <pre>
	 * amadeus.shopping.flightAvailabilitiesSearch.get(params);</pre>
	 *
	 * @param params the parameters to send to the API
	 * @return an API resource
	 * @throws ResponseException when an exception occurs
	 */
	public FlightAvailabilitySearch[] get(Params params) throws ResponseException {
		Response response = client.get("/v1/shopping/availability/flight-availabilities", params);
		return (FlightAvailabilitySearch[]) Resource.fromArray(response, FlightAvailabilitySearch[].class);
	}
	
	/**
	 * Convenience method for calling <code>get</code> without any parameters.
	 * @see FlightAvailabilitiesSearch#get()
	 */
	public FlightAvailabilitySearch[] get() throws ResponseException {
		return get(null);
	}
	
	/**
	 * <p>
	 *   The Amadeus Flight Availability API provides a list of flights with seats for sale,
	 *   and the quantity of seats available in different fare classes on a given itinerary.
	 *   Additional information such as carrier and aircraft information,
	 *   the departure and arrival terminals, schedule, and route are also provided.
	 * </p>
	 *
	 * <pre>
	 * amadeus.shopping.flightAvailabilitiesSearch.post(body);</pre>
	 *
	 * @param body the parameters to send to the API as a JsonObject
	 * @return an API resource
	 * @throws ResponseException when an exception occurs
	 */
	public FlightAvailabilitySearch[] post(JsonObject body) throws ResponseException {
		Response response = client.post("/v1/shopping/availability/flight-availabilities", body);
		return (FlightAvailabilitySearch[]) Resource.fromArray(response, FlightAvailabilitySearch[].class);
	}
	
	/**
	 * <p>
	 *   The Amadeus Flight Availability API provides a list of flights with seats for sale,
	 *   and the quantity of seats available in different fare classes on a given itinerary.
	 *   Additional information such as carrier and aircraft information,
	 *   the departure and arrival terminals, schedule, and route are also provided.
	 * </p>
	 *
	 * <pre>
	 * amadeus.shopping.flightAvailabilitiesSearch.post(body);</pre>
	 *
	 * @param body the parameters to send to the API as a String
	 * @return an API resource
	 * @throws ResponseException when an exception occurs
	 */
	public FlightAvailabilitySearch[] post(String body) throws ResponseException {
		Response response = client.post("/v1/shopping/availability/flight-availabilities", body);
		return (FlightAvailabilitySearch[]) Resource.fromArray(response, FlightAvailabilitySearch[].class);
	}
	
	/**
	 * Convenience method for calling <code>post</code> without any parameters.
	 *
	 * @see FlightAvailabilitiesSearch#post()
	 */
	public FlightAvailabilitySearch[] post() throws ResponseException {
		return post((String) null);
	}
}
