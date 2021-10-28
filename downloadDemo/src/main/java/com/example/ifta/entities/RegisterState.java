package com.example.ifta.entities;

import com.example.ifta.utils.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "register_state")
@Getter
@Setter
@NoArgsConstructor
public class RegisterState extends BaseEntity {

    @Column(name="state_name")
    private String stateName;

    @Column(name="state_code")
    private String stateCode;

}
