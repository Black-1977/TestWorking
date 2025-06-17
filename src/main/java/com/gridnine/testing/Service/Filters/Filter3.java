package com.gridnine.testing.Service.Filters;

import com.gridnine.testing.Model.Flight;
import com.gridnine.testing.Model.Segment;
import com.gridnine.testing.Service.FlightService;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class Filter3 {
    private final long TIMEOFSTAY = 2L;

    public List<Flight> filter3(FlightService flightService) {
        List<Flight> flights = flightService.getAllFlights();
        List<Flight> filteredFlights = new ArrayList<Flight>();
        for (Flight flight : flights) {
            long hoursSum = 0;
            List<Segment> segments = flight.getSegments();
            Iterator<Segment> segmentIterator = segments.iterator();
            Segment segment = segmentIterator.next();
            LocalDateTime arrived = segment.getArrivalDate();
            while (segmentIterator.hasNext()) {
                segment = segmentIterator.next();
                LocalDateTime departure = segment.getDepartureDate();
                long hours = Duration.between(arrived, departure).toHours();
                hoursSum += hours;
                arrived = segment.getArrivalDate();
            }
            if (hoursSum >= TIMEOFSTAY) {
                filteredFlights.add(flight);
            }
        }
        return filteredFlights;
    }
}
