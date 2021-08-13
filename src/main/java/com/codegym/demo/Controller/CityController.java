package com.codegym.demo.Controller;

import com.codegym.demo.model.City;
import com.codegym.demo.model.Nation;
import com.codegym.demo.service.City.ICityService;
import com.codegym.demo.service.Nation.INationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class CityController {
  ;
@Autowired
    INationService nationService;


    @ModelAttribute("nation")
    public Iterable<Nation> nations(){
        return nationService.findAll();
    }
    @Autowired
    ICityService cityService;
    @GetMapping("/create-city")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("city/create");
        modelAndView.addObject("city", new City());
        return modelAndView;
    }

    @PostMapping("/create-city")
    public ModelAndView saveCustomer(@ModelAttribute("city") City city) {
        cityService.save(city);
        ModelAndView modelAndView = new ModelAndView("city/create");
        modelAndView.addObject("customer", new City());
        modelAndView.addObject("message", "New City created successfully");
        return modelAndView;
    }
    @GetMapping("/cities")
    public ModelAndView list() {
        ModelAndView modelAndView = new ModelAndView("city/list");
        modelAndView.addObject("cities", cityService.findAll());
        return modelAndView;
    }
    @GetMapping("/edit-city/{id}")
    public ModelAndView showEditForm(@PathVariable Long id) {
        Optional<City> cityOptional = cityService.findById(id);
        if (cityOptional.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("city/edit");
            modelAndView.addObject("city", cityOptional.get());
            return modelAndView;
        } else {
            return new ModelAndView("/error.404");
        }
    }

    @PostMapping("/edit-city")
    public ModelAndView updateCustomer(@ModelAttribute("city") City city) {
       cityService.save(city);
        ModelAndView modelAndView = new ModelAndView("/city/edit");
        modelAndView.addObject("city", city);
        modelAndView.addObject("message", "Customer updated successfully");
        return modelAndView;
    }
    @GetMapping("/delete-city/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id) {
        Optional<City> cityOptional = cityService.findById(id);
        if (cityOptional.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("/city/delete");
            modelAndView.addObject("city", cityOptional.get());
            return modelAndView;

        } else {
            return new ModelAndView("/error.404");
        }
    }

    @PostMapping("/delete-city")
    public String deleteCustomer(@ModelAttribute("city") City city) {
        cityService.remove(city.getId());
        return "redirect:cities";
    }


}
