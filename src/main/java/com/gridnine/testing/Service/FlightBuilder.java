package com.gridnine.testing.Service;


import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * Factory class to get sample list of flights.
 */
@Service
public class FlightBuilder {
    private final FlightService flightService;

    public FlightBuilder(FlightService flightService) {
        this.flightService = flightService;
    }

    public void createFlights() {
                LocalDateTime threeDaysFromNow = LocalDateTime.now().plusDays(3);
                //A normal flight with two hour duration
                flightService.createFlight(threeDaysFromNow, threeDaysFromNow.plusHours(2));
                //A normal multi segment flight
                flightService.createFlight(threeDaysFromNow, threeDaysFromNow.plusHours(2),
                        threeDaysFromNow.plusHours(3), threeDaysFromNow.plusHours(5));
                //A flight departing in the past
                flightService.createFlight(threeDaysFromNow.minusDays(6), threeDaysFromNow);
                //A flight that departs before it arrives
                flightService.createFlight(threeDaysFromNow, threeDaysFromNow.minusHours(6));
                //A flight with more than two hours ground time
                flightService.createFlight(threeDaysFromNow, threeDaysFromNow.plusHours(2),
                        threeDaysFromNow.plusHours(5), threeDaysFromNow.plusHours(6));
                //Another flight with more than two hours ground time
                flightService.createFlight(threeDaysFromNow, threeDaysFromNow.plusHours(2),
                        threeDaysFromNow.plusHours(3), threeDaysFromNow.plusHours(4),
                        threeDaysFromNow.plusHours(6), threeDaysFromNow.plusHours(7));
    }
}
