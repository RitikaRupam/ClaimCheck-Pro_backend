package com.claimcheck.repository;

import com.claimcheck.model.Claim;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClaimRepository extends JpaRepository<Claim, String> {

    long countByStatus(String status);

    @Query("SELECT c.errorCode, COUNT(c) FROM Claim c GROUP BY c.errorCode")
    List<Object[]> getErrorCounts();
}