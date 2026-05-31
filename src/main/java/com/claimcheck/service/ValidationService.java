package com.claimcheck.service;

import com.claimcheck.model.Claim;

import org.springframework.stereotype.Service;

@Service
public class ValidationService {

    public boolean validate(Claim claim) {

        if (claim.procedureCode == null || claim.procedureCode.isEmpty()) {
            claim.errorCode = "MISSING_PROCEDURE";
            return false;
        }

        if (claim.amount <= 0) {
            claim.errorCode = "INVALID_AMOUNT";
            return false;
        }

        return true;
    }
}