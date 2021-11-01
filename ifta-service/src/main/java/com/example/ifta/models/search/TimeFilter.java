package com.example.ifta.models.search;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.OffsetDateTime;

/**
 * Time range filter.
 */
@Getter
@Setter
@NoArgsConstructor
public class TimeFilter {

    /**
     * Start of filter range.
     */
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private OffsetDateTime from;

    /**
     * End of filter range.
     */
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private OffsetDateTime to;
}
