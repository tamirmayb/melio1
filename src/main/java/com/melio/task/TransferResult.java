package com.melio.task;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class TransferResult {
    private double totalAmount;
    private List<TransferResultContent> content;

    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    @Setter
    @ToString
    @JsonIgnoreProperties(ignoreUnknown = true)
    @Builder
    public static class TransferResultContent {
        private double amount;
        private String individualName;
        private String sourceBankAccount;
        private String sourceRoutingNumber;
        private String destinationBankAccount;
        private String destinationRoutingNumber;
        private String companyEntryDescription;

        public static TransferResultContent ofBankA(Transfer transfer) {
            return TransferResultContent.builder()
                    .amount(transfer.getAmount())
                    .individualName(transfer.getOrganizationCompanyName())
                    .sourceBankAccount(transfer.getSourceAccountNumber())
                    .sourceRoutingNumber(transfer.getSourceRoutingNumber())
                    .destinationBankAccount(transfer.getDestinationAccountNumber())
                    .destinationRoutingNumber(transfer.getDestinationRoutingNumber())
                    .companyEntryDescription(transfer.getVendorCompanyName())
                    .build();

        }
    }

}
