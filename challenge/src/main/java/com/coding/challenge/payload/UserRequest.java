package com.coding.challenge.payload;

import lombok.Data;

@Data
public class UserRequest {

    private String firstName;
    private String lastName;
    private String email;
    private String address;
    private String phone;

}
