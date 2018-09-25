package com.san;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServiceTemplate {
	
    @Autowired
    private ServiceTRepository serviceTRepository;

    public List<ServiceT> getAll() {
        List<ServiceT> records = new ArrayList<>();
        serviceTRepository.findAll().forEach(records::add);
        return records;
    }

    public ServiceT getOne(Integer id) {
        return serviceTRepository.findOne(id);
    }

    public void add(ServiceT serviceT) {
        serviceTRepository.save(serviceT);
    }

    public void update(ServiceT serviceT) {
        // if exists updates otherwise inserts
        serviceTRepository.save(serviceT);
    }

    public void delete(Integer id) {
        serviceTRepository.delete(id);
    }
}
