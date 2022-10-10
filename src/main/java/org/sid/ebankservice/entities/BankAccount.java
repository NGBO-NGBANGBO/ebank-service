package org.sid.ebankservice.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sid.ebankservice.enums.AccountType;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class BankAccount {
    @Id
    private String id;
    private Date CreateAt;
    private Double balance;
    private AccountType Type;
    private String currency;
}
