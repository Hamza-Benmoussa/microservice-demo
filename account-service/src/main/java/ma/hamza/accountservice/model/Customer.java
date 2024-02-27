package ma.hamza.accountservice.model;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Customer {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
}
