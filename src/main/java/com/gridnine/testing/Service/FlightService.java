package com.gridnine.testing.Service;

import com.gridnine.testing.Model.Flight;
import com.gridnine.testing.Model.Segment;
import com.gridnine.testing.Repository.FlightRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class FlightService {
    private final FlightRepository flightRepository;
    private final SegmentService segmentService;


    public FlightService(FlightRepository flightRepository, SegmentService segmentService) {
        this.flightRepository = flightRepository;
        this.segmentService = segmentService;
    }

    public void createFlight(final LocalDateTime... dates) {
        if ((dates.length % 2) != 0) {
            throw new IllegalArgumentException(
                    "you must pass an even number of dates");
        }
        Flight flight = new Flight();
        flightRepository.save(flight);
        List<Segment> segments = new ArrayList<>(dates.length / 2);
        for (int i = 0; i < (dates.length - 1); i += 2) {
            segments.add(segmentService.createSegment(flight, dates[i], dates[i + 1]));
        }
        flight.setSegments(segments);
        flightRepository.save(flight);
    }

    public List<Flight> getAllFlights() {
        List<Flight> flights = flightRepository.findAll();
        List<Segment> segments;

        for (Flight flight : flights) {
            segments = segmentService.getSegmentsByFlightID(flight.getId());
            flight.setSegments(segments);
        }
        return flights;
    }
}
