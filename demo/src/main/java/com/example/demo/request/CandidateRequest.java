package com.example.demo.request;

import org.springframework.web.multipart.MultipartFile;

public record CandidateRequest(String name, String gender, String age, String email, String position, MultipartFile avatar) {
}
