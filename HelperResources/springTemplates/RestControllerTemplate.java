package com.san;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/home")
public class RestControllerTemplate {
	
    @Autowired
    private ServiceTService serviceTService;

    /*
    **Return a listing of all the resources
    */
    @GetMapping
    public List<ServiceT> getAll() {
        return serviceTService.getAll();
    }

    /*
    **Return one resource
    */
    @GetMapping("/{id}")
    public ServiceT getOne(@PathVariable Integer id) {
        return serviceTService.getOne(id);
    }

    /*
    **Store a newly created resource in storage.
    */
    @PostMapping
    public void add(@RequestBody ServiceT serviceT) {
        serviceTService.add(serviceT);
    }

    /*
    **Update the specified resource in storage.
    */
    @PatchMapping
    public void update(@RequestBody ServiceT serviceT) {
        serviceTService.update(serviceT);
    }

    /*
    **Remove the specified resource from storage.
    */
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        serviceTService.delete(id);
    }
}
