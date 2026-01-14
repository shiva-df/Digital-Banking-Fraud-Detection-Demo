package org.example;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Transaction {

    @Id
    private String transactionId;

    private String timestamp;
    private String type;
    private String channel;
    private String sender;
    private String receiver;
    private double amount;
    private String status;

    private String ipAddress;
    private String location;
}
