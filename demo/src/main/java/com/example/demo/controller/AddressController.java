package com.example.demo.controller;

import com.example.demo.entity.Address;
import com.example.demo.service.AddressService;
import jakarta.annotation.Resource;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Scope("prototype")
@RequestMapping("/address")
@CrossOrigin(origins="*")
public class AddressController {
    @Resource
    private AddressService addressService;

    @GetMapping("list")
    public Object queryList(Address address) {
        return addressService.findAll(address);
    }
}
