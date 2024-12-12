package com.example.demo.service;

import com.example.demo.entity.Address;

import java.util.List;

public interface AddressService {
    public int delete(Address address);
    public List<Address> findAll(Address address);
    public int insert(Address address);
    public int update(Address address);
}
