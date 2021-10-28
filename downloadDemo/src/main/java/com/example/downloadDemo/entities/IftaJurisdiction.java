package com.example.downloadDemo.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "ifta_jurisdiction")
@Getter
@Setter
@NoArgsConstructor
public class IftaJurisdiction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "register_state_id")
    private Long registerStateId;

    @Column(name="created_on")
    private Integer createdOn;

    @Column(name="created_by")
    private String createdBy;

    @Column(name="updated_on")
    private Integer updatedOn;

    @Column(name="updated_by")
    private String updatedBy;

    @Column(name="code")
    private String code;

}
