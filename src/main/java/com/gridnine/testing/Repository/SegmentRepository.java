package com.gridnine.testing.Repository;

import com.gridnine.testing.Model.Segment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SegmentRepository extends JpaRepository<Segment, Integer> {
    List<Segment> findAllByFlightId(int id);
}
