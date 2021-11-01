package com.example.ifta.models;

import com.example.ifta.models.search.TimeFilter;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * DTO containing search params.
 */
@Getter
@Setter
@NoArgsConstructor
public class MileageSearchDto {

    /**
     * Search param used for retrieving mileage report details within actual start time range.
     */
    private TimeFilter startTimeFilter;

    /**
     * Search param used for retrieving mileage report details within actual end time range.
     */
    private TimeFilter endTimeFilter;
}
