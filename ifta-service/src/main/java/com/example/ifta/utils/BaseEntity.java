package com.example.ifta.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
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
public abstract class BaseEntity implements Serializable {

    /**
     * Database entry ID.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
