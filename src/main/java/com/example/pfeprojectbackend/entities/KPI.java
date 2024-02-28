package com.example.pfeprojectbackend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class KPI {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long kpiId;



    private String Points;
}
