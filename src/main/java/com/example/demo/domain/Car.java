package com.example.demo.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
public class Car {

    @Id
    private Long id;

    @NonNull
    private String model;

    @NonNull
    private String color;
}
