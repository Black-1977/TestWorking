package com.gridnine.testing.Model;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "flight_list")
@Data
@AllArgsConstructor
@Builder
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id"/*, nullable = false*/)
    private int id;

    @Setter
    @OneToMany(mappedBy = "id", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Segment> segments;

    public Flight(final List<Segment> segs) { segments = segs; }
    public Flight() {}

    public void setSegments(List<Segment> segments) {
        this.segments = segments;
    }

    public List<Segment> getSegments() {
        return segments;
    }

    public int getId() { return id; }

    @Override
    public String toString() {
        return segments.stream().map(Object::toString)
                .collect(Collectors.joining(" "));
    }
}
