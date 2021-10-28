package com.example.ifta.entities;

import com.example.ifta.utils.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "registered_state")
@Getter
@Setter
@NoArgsConstructor
public class RegisterState extends BaseEntity {

    @Column(name="name")
    private String stateName;

    @Column(name="code")
    private String stateCode;

}
