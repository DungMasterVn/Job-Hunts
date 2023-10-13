package com.example.demo.repository;

import com.example.demo.model.Candidate;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class CandidateRepo {
    private ConcurrentHashMap<String, Candidate> candidates = new ConcurrentHashMap<>();
    public CandidateRepo(){
    }
    public Candidate add(Candidate candidate){
        String id = UUID.randomUUID().toString();
        candidate.setId(id);
        candidates.put(id,candidate);
        return candidate;
    }

    public Collection<Candidate> getAll(){
        return candidates.values();
    }

    public Candidate findById(String id){
        return candidates.get(id);
    }
    @PostConstruct
    public void addSomeData(){
        this.add(Candidate.builder()
                .name("Jonathan Joestar")
                .gender("Male")
                .age("28")
                .email("jonathan69@gmail.com")
                .position("Tech Lead")
                .avatar("jojo.jfif")
                .build());

        this.add(Candidate.builder()
                .name("Dio Brando")
                .gender("Male")
                .age("27")
                .email("dio79@gmail.com")
                .position("Designer")
                .avatar("dio.png")
                .build());
    }
}
