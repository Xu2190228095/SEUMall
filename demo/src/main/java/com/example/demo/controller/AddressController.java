package com.example.demo.controller;

import com.example.demo.entity.Address;
import com.example.demo.service.AddressService;
import jakarta.annotation.Resource;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    // 根据 cid 查询所有地址
    @GetMapping("/byCid/{cid}")
    public List<Address> getAddressesByCid(@PathVariable Integer cid) {
        return addressService.getAddressesByCid(cid);
    }

    // 添加新地址
    @PostMapping("/add")
    public void addAddress(@RequestBody Address address) {
        addressService.addAddress(address);
    }

    // 删除地址
    @DeleteMapping("/delete/{id}")
    public void deleteAddress(@PathVariable Integer id) {
        addressService.deleteAddress(id);
    }
}
