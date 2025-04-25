package dev.heryan.fibers_stack;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class SaveUserWebRequest {
    private String id;
    private String username;
    private String name;
    private String email;
    private String phone;
    private String address;
    private Date dateOfBirth;
}

