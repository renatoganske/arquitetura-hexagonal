package com.renatoganske.arquitetura_hexagonal.adapters.in.controller;

import com.renatoganske.arquitetura_hexagonal.adapters.in.controller.mapper.CustomerMapper;
import com.renatoganske.arquitetura_hexagonal.adapters.in.controller.request.CustomerRequest;
import com.renatoganske.arquitetura_hexagonal.adapters.in.controller.response.CustomerResponse;
import com.renatoganske.arquitetura_hexagonal.adapters.out.DeleteCustomerByIdAdapter;
import com.renatoganske.arquitetura_hexagonal.application.ports.in.FindCustomerByIdInputPort;
import com.renatoganske.arquitetura_hexagonal.application.ports.in.InsertCustomerInputPort;
import com.renatoganske.arquitetura_hexagonal.application.ports.in.UpdateCustomerInputPort;
import jakarta.validation.Valid;
import org.apache.kafka.common.protocol.types.Field;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    @Autowired
    private InsertCustomerInputPort insertCustomerInputPort;

    @Autowired
    private FindCustomerByIdInputPort findCustomerByIdInputPort;

    @Autowired
    private UpdateCustomerInputPort updateCustomerInputPort;

    @Autowired
    private DeleteCustomerByIdAdapter deleteCustomerByIdAdapter;

    @Autowired
    private CustomerMapper customerMapper;

    @PostMapping
    public ResponseEntity<Void> insert(@Valid @RequestBody CustomerRequest customerRequest) {
        var customer = customerMapper.toCustomer(customerRequest);
        insertCustomerInputPort.insert(customer, customerRequest.getZipCode());
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponse> findById(@PathVariable final String id) {
        var customer = findCustomerByIdInputPort.find(id);
        var customerResponse = customerMapper.toCustomerResponse(customer);
        return ResponseEntity.ok(customerResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable final String id,
                                       @Valid @RequestBody CustomerRequest customerRequest) {
        var customer = customerMapper.toCustomer(customerRequest);
        customer.setId(id);
        updateCustomerInputPort.update(customer, customerRequest.getZipCode());
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable final String id) {
        findCustomerByIdInputPort.find(id);
        deleteCustomerByIdAdapter.delete(id);
        return ResponseEntity.noContent().build();
    }

}
