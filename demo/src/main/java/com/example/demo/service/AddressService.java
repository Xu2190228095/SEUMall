package com.example.demo.service;

import com.example.demo.entity.Address;

import java.util.List;

public interface AddressService {
    public int delete(Address address);
    public List<Address> findAll(Address address);
    public int insert(Address address);
    public int update(Address address);

    // 根据cid查询所有地址
    public List<Address> getAddressesByCid(Integer cid);

    // 添加新地址
    public void addAddress(Address address);

    // 删除地址
    public void deleteAddress(Integer id);
}
