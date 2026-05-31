package com.claimcheck.model;

import jakarta.persistence.*;

@Entity
public class Claim {

    @Id
    public String claimId;

    public String patientId;
    public String procedureCode;
    public double amount;
    public String status;
    public String errorCode;
}