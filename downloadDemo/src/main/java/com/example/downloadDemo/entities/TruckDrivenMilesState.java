package com.example.downloadDemo.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "truck_driven_miles_state")
@Getter
@Setter
@NoArgsConstructor
public class TruckDrivenMilesState {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "state_jurisdiction")
    private Long stateJurisdiction;

    @Column(name="truck_id")
    private String truckId;

    @Column(name="state_telemetry_id")
    private Integer startTelemetryId;

    @Column(name="start_odometer")
    private Integer startOdometer;

    @Column(name="start_date_time")
    private Date startDateTime;

    @Column(name="end_odometer")
    private Integer endOdometer;

    @Column(name="end_date_time")
    private Date endDateTime;

    @Column(name="end_telemetry_id")
    private Integer endTelemetryId;

    @Column(name="sum_total_miles")
    private Integer sumTotalMiles;

    @Column(name="date")
    private Date date;

    @Column(name="created_on")
    private Integer createdOn;

    @Column(name="created_by")
    private String createdBy;

    @Column(name="updated_on")
    private Integer updatedOn;

    @Column(name="updated_by")
    private String updatedBy;
}
