package com.example.demo.service.impl;

import com.example.demo.dao.AddressDao;
import com.example.demo.entity.Address;
import com.example.demo.service.AddressService;
import jakarta.annotation.Resource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@Scope("prototype")
public class AddressServiceImpl implements AddressService {
    @Resource
    private AddressDao addressDao;

    @Override
    public int delete(Address address) {
        return addressDao.delete(address);
    }

    @Override
    public List<Address> findAll(Address address) {
        return addressDao.findAll(address);
    }

    @Override
    public int insert(Address address) {
        return addressDao.insert(address);
    }

    @Override
    public int update(Address address) {
        return addressDao.update(address);
    }

    @Override
    public List<Address> getAddressesByCid(Integer cid) {
        return addressDao.findAllByCid(cid);
    }

    @Override
    public void addAddress(Address address) {
        addressDao.insertAddress(address);
    }

    @Override
    public void deleteAddress(Integer id) {
        addressDao.deleteAddress(id);
    }
}
