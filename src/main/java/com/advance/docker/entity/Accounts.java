package com.advance.docker.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ACCOUNT_DETAIL")
public class Accounts {

    @Id
    @Column(name = "ACCOUNT_NO")
    private String accountNo;


    @Column(name = "CUSTOMER_ID",unique = true)
    private int customerId;


    @Column(name = "BALANCE")
    private Double balance;

}
