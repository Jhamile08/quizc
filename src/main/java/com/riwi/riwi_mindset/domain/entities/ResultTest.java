package com.riwi.riwi_mindset.domain.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "resultTest")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResultTest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idResultTest;
    @Column(nullable = false)
    private String id_coder;
    @Column(nullable = false)
    private String result;
}
