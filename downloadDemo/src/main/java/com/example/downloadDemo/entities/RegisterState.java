package com.example.downloadDemo.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "register_state")
@Getter
@Setter
@NoArgsConstructor
public class RegisterState {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name="state_name")
    private String stateName;

    @Column(name="state_code")
    private String stateCode;

}
