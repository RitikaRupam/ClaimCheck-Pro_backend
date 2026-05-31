package com.claimcheck.util;

import com.claimcheck.model.Claim;

import java.util.*;

public class DataGenerator {

    public static List<Claim> generate(int size) {

        List<Claim> claims = new ArrayList<>();
        Random rand = new Random();

        for (int i = 1; i <= size; i++) {

            Claim c = new Claim();

            c.claimId = "C" + i;
            c.patientId = "P" + i;
            c.status = "SUBMITTED";

            double r = rand.nextDouble();

            // 🔥 21% bad data
            if (r < 0.21) {

                // 43% of rejections from one issue
                if (r < 0.09) {
                    c.procedureCode = ""; // MISSING_PROCEDURE
                    c.amount = 5000;
                }
                else if (r < 0.15) {
                    c.procedureCode = "PROC" + rand.nextInt(100);
                    c.amount = -100; // INVALID_AMOUNT
                }
                else {
                    c.procedureCode = "ABC" + rand.nextInt(100); // INVALID_PROC
                    c.amount = 5000;
                }

            } else {
                // valid data
                c.procedureCode = "PROC" + rand.nextInt(100);
                c.amount = rand.nextInt(10000) + 100;
            }

            claims.add(c);
        }

        return claims;
    }
}