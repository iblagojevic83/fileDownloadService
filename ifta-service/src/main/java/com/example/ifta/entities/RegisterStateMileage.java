package com.example.ifta.entities;

import com.example.ifta.models.enums.RegisteredStateEnum;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RegisterStateMileage {

    private RegisteredStateEnum state;
    private Integer mileage;
}
