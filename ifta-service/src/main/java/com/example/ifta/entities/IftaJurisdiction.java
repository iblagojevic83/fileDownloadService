package com.example.ifta.entities;

import com.example.ifta.utils.BaseAuditEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "ifta_jurisdiction")
@Getter
@Setter
@NoArgsConstructor
public class IftaJurisdiction extends BaseAuditEntity {

    @Column(name = "register_state_id")
    private Long registerStateId;

    @Column(name="code")
    private String code;

}
