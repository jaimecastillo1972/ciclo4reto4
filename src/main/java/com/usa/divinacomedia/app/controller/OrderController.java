package com.usa.divinacomedia.app.controller;

import com.usa.divinacomedia.app.model.Order;
import com.usa.divinacomedia.app.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("order")
@CrossOrigin(origins = "*")
public class OrderController {
    @Autowired
    private OrderService service;

    @GetMapping("/all")
    public List<Order> getAll(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Order> getOrder(@PathVariable("id") Integer id){
        return service.getOrder(id);
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Order save(@RequestBody Order order){
        return service.save(order);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Order update(@RequestBody Order order){
        return service.update(order);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") Integer id){
        return service.delete(id);
    }

    @GetMapping("zona/{zona}")
    public List<Order> findByZone(@PathVariable("zona") String zona){
        return service.findByZone(zona);
    }

    @GetMapping("salesman/{id}")
    public List<Order> findBySalesManId(@PathVariable("id") Integer id){
        return service.findBySalesManId(id);
    }

    @GetMapping("date/{date}/{id}")
    public List<Order> findByDateAndId(@PathVariable("date") Date registerDay, @PathVariable("id") Integer id){
        return service.findByDateAndId(registerDay, id);
    }

    @GetMapping("state/{state}/{id}")
    public List<Order> findByStatus(@PathVariable("state") String state){
        return service.findByStatus(state);
    }
}
