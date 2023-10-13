package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Candidate {
    private String id;
    private String name;
    private String gender;
    private String age;
    private String email;
    private String position;
    private String avatar;
}
