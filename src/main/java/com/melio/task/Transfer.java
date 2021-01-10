package com.melio.task;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class Transfer {
    private double amount;
    private String organizationCompanyName;
    private String vendorCompanyName;
    private String sourceRoutingNumber;
    private String sourceAccountNumber;
    private String destinationRoutingNumber;
    private String destinationAccountNumber;
    private String transferType;
    private String Bank;
}
