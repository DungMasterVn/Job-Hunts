package com.example.demo.repository;

import com.example.demo.model.Employer;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class EmployerRepo {
    private ConcurrentHashMap<String, Employer> employers = new ConcurrentHashMap<>();
    public EmployerRepo(){
    }

    //Create random UUID
    public Employer add(Employer employer){
        String id = UUID.randomUUID().toString();
        employer.setId(id);
        employers.put(id,employer);
        return employer;
    }

    public Collection<Employer> getAll(){
        return employers.values();
    }

    public Employer findById(String id){
        return employers.get(id);
    }

    @PostConstruct
    public void addSomeData(){
        this.add(Employer.builder()
                .name("FPT")
                .email("hr@fpt.com.vn")
                .website("http://fpt.vn")
                .logo_path("logo.jpg")
                .build());

        this.add(Employer.builder()
                .name("CMC")
                .email("hr@cmc.com.vn")
                .website("http://cmc.com.vn")
                .logo_path("logo.jpg")
                .build());

    }
}
