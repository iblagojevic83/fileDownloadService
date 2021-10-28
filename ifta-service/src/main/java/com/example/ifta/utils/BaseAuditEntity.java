package com.example.ifta.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

import static lombok.AccessLevel.PROTECTED;

/**
 * Generic entity is from be extended by concrete entities.
 *
 * @author Nikola Stanar
 */
@MappedSuperclass
@NoArgsConstructor
@AllArgsConstructor(access = PROTECTED)
@Getter
public abstract class BaseAuditEntity implements Serializable {

    /**
     * Database entry ID.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="created_on")
    private Integer createdOn;

    @Column(name="created_by")
    private String createdBy;

    @Column(name="updated_on")
    private Integer updatedOn;

    @Column(name="updated_by")
    private String updatedBy;
}
