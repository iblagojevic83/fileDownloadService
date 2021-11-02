package com.example.ifta.entities;

import com.example.ifta.utils.BaseEntity;
import com.vladmihalcea.hibernate.type.array.ListArrayType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@TypeDef(
        name = "list-array",
        typeClass = ListArrayType.class
)
public class VehicleMilesState extends BaseEntity {

    @Column(name = "truck_id")
    private String truckId;

    @Column(name = "start_odometer")
    private Integer startOdometer;

    @Column(name = "end_odometer")
    private Integer endOdometer;

    @Column(name = "sum_total_miles")
    private Integer sumTotalMiles;

    @Type(type = "list-array")
    @Column(name = "total_mileages_per_jurisdiction", columnDefinition = "register_state_mileage[]")
    private List<RegisterStateMileage> totalMileagesPerJurisdiction;
}
