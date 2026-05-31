package com.claimcheck.controller;

import com.claimcheck.model.Claim;
import com.claimcheck.service.ClaimService;
import com.claimcheck.util.DataGenerator;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class ClaimController {

    private final ClaimService claimService;

    public ClaimController(ClaimService claimService) {
        this.claimService = claimService;
    }

    @PostMapping("/process")
    public List<Claim> process(@RequestBody List<Claim> claims) {
        return claimService.processClaims(claims);
    }

    @GetMapping("/claims")
    public List<Claim> getClaims() {
        return claimService.getClaims();
    }

    @GetMapping("/analytics")
    public Map<String, Object> analytics() {
        return claimService.getAnalytics();
    }

    // 🔥 generate data
    @GetMapping("/generate")
    public List<Claim> generate() {
        return claimService.processClaims(DataGenerator.generate(100000));
    }
}