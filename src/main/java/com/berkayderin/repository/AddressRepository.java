package com.berkayderin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.berkayderin.model.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

}
