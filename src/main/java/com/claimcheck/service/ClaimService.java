package com.claimcheck.service;

import com.claimcheck.model.Claim;
import com.claimcheck.repository.ClaimRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ClaimService {

    private final ClaimRepository claimRepository;
    private final ValidationService validationService;
    private final RuleEngine ruleEngine;

    public ClaimService(ClaimRepository claimRepository,
                        ValidationService validationService,
                        RuleEngine ruleEngine) {
        this.claimRepository = claimRepository;
        this.validationService = validationService;
        this.ruleEngine = ruleEngine;
    }

    // 🔥 PROCESS + SAVE TO DB
    public List<Claim> processClaims(List<Claim> inputClaims) {

        for (Claim claim : inputClaims) {

            boolean valid = validationService.validate(claim);

            if (!valid) {
                claim.status = "REJECTED";
            } else {
                ruleEngine.applyRules(claim);

                if ("SUBMITTED".equals(claim.status)) {
                    claim.status = "APPROVED";
                }
            }
        }

        return claimRepository.saveAll(inputClaims);
    }

    public List<Claim> getClaims() {
        return claimRepository.findAll();
    }

    // 🔥 FINAL FIXED ANALYTICS METHOD
    public Map<String, Object> getAnalytics() {

        long total = claimRepository.count();
        long approved = claimRepository.countByStatus("APPROVED");
        long rejected = claimRepository.countByStatus("REJECTED");

        double acceptanceRate = total == 0 ? 0 : (approved * 100.0 / total);
        double rejectionRate = total == 0 ? 0 : (rejected * 100.0 / total);

        List<Object[]> errorData = claimRepository.getErrorCounts();

        Map<String, Integer> errors = new HashMap<>();

        for (Object[] row : errorData) {

            String error = row[0] != null ? row[0].toString() : "NO_ERROR";
            int count = ((Long) row[1]).intValue();

            errors.put(error, count);
        }

        String topError = "";
        int max = 0;

        for (Map.Entry<String, Integer> e : errors.entrySet()) {
            if (e.getValue() > max) {
                max = e.getValue();
                topError = e.getKey();
            }
        }

        double topErrorPercent = total == 0 ? 0 : (max * 100.0 / total);

        Map<String, Object> result = new HashMap<>();
        result.put("total", total);
        result.put("approved", approved);
        result.put("rejected", rejected);
        result.put("acceptanceRate", acceptanceRate);
        result.put("rejectionRate", rejectionRate);
        result.put("topError", topError);
        result.put("topErrorPercent", topErrorPercent);
        result.put("errors", errors);
        
        return result;
    }
}