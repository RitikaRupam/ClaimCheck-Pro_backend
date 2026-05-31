package com.claimcheck.service;

import com.claimcheck.model.Claim;

import org.springframework.stereotype.Service;

@Service
public class RuleEngine {

    public void applyRules(Claim claim) {

        if (claim.amount > 10000) {
            claim.status = "REVIEW";
            claim.errorCode = "HIGH_AMOUNT";
            return;
        }

        if (!claim.procedureCode.startsWith("PROC")) {
            claim.status = "REJECTED";
            claim.errorCode = "INVALID_PROCEDURE";
        }
    }
}