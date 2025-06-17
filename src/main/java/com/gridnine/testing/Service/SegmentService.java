package com.gridnine.testing.Service;

import com.gridnine.testing.Model.Flight;
import com.gridnine.testing.Model.Segment;
import com.gridnine.testing.Repository.FlightRepository;
import com.gridnine.testing.Repository.SegmentRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class SegmentService {
    private final SegmentRepository segmentRepository;

    public SegmentService(SegmentRepository segmentRepository) {
        this.segmentRepository = segmentRepository;
    }

    public Segment createSegment(Flight flight, final LocalDateTime... dates) {
        Segment segment = new Segment(flight, dates[0], dates[1]);
        segmentRepository.save(segment);
        return segment;
    }

    public List<Segment> getAllSegments() {
        return segmentRepository.findAll();
    }

    public List<Segment> getSegmentsByFlightID(int id) {
        return segmentRepository.findAllByFlightId(id);
    }
}
