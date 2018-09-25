package com.san;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/home")
public class ControllerTemplate {
	
    /*
    **Display a listing of the resource
    */
    @GetMapping
    public String index(Model model) {
        return "home/index";
    }

    /*
    **Show the form for creating a new resource.
    */
    @GetMapping(path = "/create")
    public String create(Model model) {
        return "home/new";
    }

    /*
    **Store a newly created resource in storage.
    */
    @PostMapping
    public String add(@RequestBody Object object, Model model) {
        return "home/stored";
    }

    /*
    **Display the specified resource.
    */
    @GetMapping("/{id}")
    public String show(@PathVariable String id, Model model) {
        // model.addAttribute("objectname", objectWithId_x);
        return "home/show";
    }

    /*
    **Show the form for editing the specified resource.
    */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable String id, Model model) {
        // model.addAttribute("objectname", objectWithId_x);
        return "home/edit";
    }

    /*
    **Update the specified resource in storage.
    */
    @PatchMapping
    public String update(@RequestBody Object object, Model model) {
        return "home/updated";
    }

    /*
    **Remove the specified resource from storage.
    */
    @DeleteMapping(path = "/{id}")
    public String destroy(@PathVariable String id, Model model) {
        return "home/deleted";
    }
}
