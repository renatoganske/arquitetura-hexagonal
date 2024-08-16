package com.renatoganske.arquitetura_hexagonal.adapters.in.controller.response;

import lombok.Data;

@Data
public class CustomerResponse {

    private String name;
    private String email;
    private AddressResponse address;

}
