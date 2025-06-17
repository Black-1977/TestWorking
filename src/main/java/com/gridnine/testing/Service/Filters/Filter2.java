package com.gridnine.testing.Service.Filters;

import com.gridnine.testing.Model.Flight;
import com.gridnine.testing.Model.Segment;
import com.gridnine.testing.Service.FlightService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Filter2 {
    public List<Flight> filter2(FlightService flightService){
        List<Flight> flights = flightService.getAllFlights();
        List<Flight> filteredFlights = new ArrayList<Flight>();
        for (Flight flight : flights) {
            boolean isFilter = false;
            List<Segment> segments = flight.getSegments();
            for (Segment segment : segments) {
                if (segment.getArrivalDate().isBefore(segment.getDepartureDate())) {
                    isFilter = true; break;
                }
            }
            if (isFilter) {
                filteredFlights.add(flight);
            }
        }
        return filteredFlights;
    }
}
