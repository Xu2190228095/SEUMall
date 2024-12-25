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

    // 根据cid查询所有地址
    public List<Address> findAllByCid(Integer cid);

    // 添加新地址
    public int insertAddress(Address address);

    // 删除地址
    public int deleteAddress(Integer id);
}
