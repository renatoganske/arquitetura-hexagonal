package com.renatoganske.arquitetura_hexagonal.adapters.out.repository;

import com.renatoganske.arquitetura_hexagonal.adapters.out.repository.entity.CustomerEntity;
import com.renatoganske.arquitetura_hexagonal.application.core.domain.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<CustomerEntity, String> {
}
