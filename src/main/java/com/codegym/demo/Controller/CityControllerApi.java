package com.codegym.demo.Controller;

import com.codegym.demo.model.City;
import com.codegym.demo.service.City.ICityService;
import com.codegym.demo.service.Nation.INationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/city")
@CrossOrigin("**")
public class CityControllerApi {
    @Autowired
    ICityService cityService;
    @Autowired
    INationService nationService;
    @GetMapping("/list")
    public ResponseEntity<Iterable<City>> showlist(){
            List<City> cityList = (List<City>) cityService.findAll();
            return new ResponseEntity<>(cityList, HttpStatus.OK);
    }
    @PostMapping("/create")
    public ResponseEntity<City> create(@RequestBody City city){
        cityService.save(city);
        return new ResponseEntity(cityService.findById(city.getId()),HttpStatus.OK);
    }
    @PutMapping("/edit/{id}")
    public ResponseEntity<City> edit(@PathVariable Long id, @RequestBody City city){
        Optional<City> cityOptional = cityService.findById(id);
        if(!cityOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        city.setId(id);
        cityService.save(city);
        return new ResponseEntity<>(city,HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<City> delete(@PathVariable Long id){
            cityService.remove(id);
            return new ResponseEntity<>(HttpStatus.OK);
    }
}
