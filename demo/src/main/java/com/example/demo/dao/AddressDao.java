package com.example.demo.dao;

import com.example.demo.entity.Address;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AddressDao {
    public int delete(Address address);
    public int insert(Address address);
    public int update(Address address);
    public List<Address> findAll(Address address);
}
