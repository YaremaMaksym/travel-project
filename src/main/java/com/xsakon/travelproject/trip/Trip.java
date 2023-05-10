package com.xsakon.travelproject.trip;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "trip_info")
public class Trip {
    @Id
    @SequenceGenerator(
            name = "trip_id_sequence",
            sequenceName = "trip_id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "trip_id_sequence"
    )
    @Column(name="trip_id", nullable = false)
    private Long id;

    @Column(name="countries", nullable = false)
    private String countries;

//    @Transient
//    private List<String> countries;

    @Column(name="cities", nullable = false)
    private String cities;

//    @Transient
//    private List<String> cities;

    @Column(nullable = false)
    private BigDecimal price;

    @Column(nullable = false)
    private Integer duration;

    @Column(nullable = false)
    private String reference;
}
