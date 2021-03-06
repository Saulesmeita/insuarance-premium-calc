package services;

import entities.Policy;
import entities.RiskType;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class PremiumCalculator {

    static final BigDecimal COEFFICIENT_FIRE_DEFAULT = new BigDecimal("0.013");
    static final BigDecimal COEFFICIENT_FIRE_HIGH = new BigDecimal("0.023");
    static final BigDecimal FIRE_INSURANCE_THRESHOLD = new BigDecimal("100");
    static final BigDecimal COEFFICIENT_WATER_DEFAULT = new BigDecimal("0.1");
    static final BigDecimal COEFFICIENT_WATER_HIGH = new BigDecimal("0.05");
    static final BigDecimal WATER_INSURANCE_THRESHOLD = new BigDecimal("10");


    public static BigDecimal calculate(Policy policy) {
        return premiumFire(policy).add(premiumWater(policy));

    }

    public static BigDecimal premiumFire(Policy policy) {
        BigDecimal sumInsuredFire = policy.policySumInsuredSubtotal(RiskType.FIRE);
        if (sumInsuredFire.compareTo(FIRE_INSURANCE_THRESHOLD) > 0) {
            return COEFFICIENT_FIRE_HIGH.multiply(sumInsuredFire).setScale(2, RoundingMode.HALF_EVEN);
        } else {
            return COEFFICIENT_FIRE_DEFAULT.multiply(sumInsuredFire).setScale(2, RoundingMode.HALF_EVEN);
        }
    }

    public static BigDecimal premiumWater(Policy policy) {
        BigDecimal sumInsuredWater = policy.policySumInsuredSubtotal(RiskType.WATER);
        if (sumInsuredWater.compareTo(WATER_INSURANCE_THRESHOLD) < 0) {
            return COEFFICIENT_WATER_DEFAULT.multiply(sumInsuredWater).setScale(2, RoundingMode.HALF_EVEN);
        } else {
            return COEFFICIENT_WATER_HIGH.multiply(sumInsuredWater).setScale(2, RoundingMode.HALF_EVEN);
        }
    }

}
