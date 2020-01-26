package services;

import entities.*;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class PremiumCalculatorTest {

    @Test
    public void example1() {
        PolicySubObject so1 = new PolicySubObject("Cupboard", new BigDecimal("100"), RiskType.FIRE);
        PolicySubObject so2 = new PolicySubObject("Sugar Monument", new BigDecimal("8"), RiskType.WATER);
        PolicyObject po1 = new PolicyObject("The Cabin");
        po1.addSubObject(so1);
        po1.addSubObject(so2);
        Policy p1 = new Policy("Some_long_Number_001", Status.REGISTERED);
        p1.addObject(po1);
        assertEquals(new BigDecimal("2.10"), PremiumCalculator.calculate(p1));
    }

    @Test
    public void example2() {
        PolicySubObject so3 = new PolicySubObject("Rocking Chair", new BigDecimal("500"), RiskType.FIRE);
        PolicySubObject so4 = new PolicySubObject("Beehive", new BigDecimal("100"), RiskType.WATER);
        PolicyObject po2 = new PolicyObject("Summer House");
        po2.addSubObject(so3);
        po2.addSubObject(so4);
        Policy p2 = new Policy("Some_long_Number_002", Status.APPROVED);
        p2.addObject(po2);
        assertEquals(new BigDecimal("16.50"), PremiumCalculator.calculate(p2));
    }

    @Test
    public void waterLow() {
        PolicySubObject so5 = new PolicySubObject("Gingerbread", new BigDecimal("2"), RiskType.WATER);
        PolicySubObject so6 = new PolicySubObject("Lemon Iceberg", new BigDecimal("2"), RiskType.WATER);
        PolicySubObject so7 = new PolicySubObject("Italian Noodles", new BigDecimal("2"), RiskType.WATER);
        PolicySubObject so8 = new PolicySubObject("Old Newspapers", new BigDecimal("2"), RiskType.WATER);

        PolicyObject po3 = new PolicyObject("The Kitchen");
        PolicyObject po4 = new PolicyObject("The Shed");

        po3.addSubObject(so5);
        po4.addSubObject(so6);
        po4.addSubObject(so7);
        po4.addSubObject(so8);
        Policy p3 = new Policy("Some_long_Number_003", Status.APPROVED);
        p3.addObject(po3);
        p3.addObject(po4);
        assertEquals(new BigDecimal("0.80"), PremiumCalculator.calculate(p3));
    }

    @Test
    public void waterThreshold() {
        PolicySubObject so5 = new PolicySubObject("Gingerbread", new BigDecimal("2"), RiskType.WATER);
        PolicySubObject so6 = new PolicySubObject("Lemon Iceberg", new BigDecimal("2"), RiskType.WATER);
        PolicySubObject so7 = new PolicySubObject("Italian Noodles", new BigDecimal("2"), RiskType.WATER);
        PolicySubObject so8 = new PolicySubObject("Old Newspapers", new BigDecimal("2"), RiskType.WATER);
        PolicySubObject so9 = new PolicySubObject("New Newspapers", new BigDecimal("2"), RiskType.WATER);

        PolicyObject po3 = new PolicyObject("The Kitchen");
        PolicyObject po4 = new PolicyObject("The Shed");

        po3.addSubObject(so5);
        po4.addSubObject(so6);
        po4.addSubObject(so7);
        po4.addSubObject(so8);
        po4.addSubObject(so9);
        Policy p4 = new Policy("Some_long_Number_004", Status.APPROVED);
        p4.addObject(po3);
        p4.addObject(po4);
        assertEquals(new BigDecimal("0.50"), PremiumCalculator.calculate(p4));
    }

    @Test
    public void waterHigh() {
        PolicySubObject so5 = new PolicySubObject("French Origami", new BigDecimal("20"), RiskType.WATER);
        PolicySubObject so6 = new PolicySubObject("Java Tales Book", new BigDecimal("20"), RiskType.WATER);
        PolicySubObject so7 = new PolicySubObject("Early Muslim Portraits Album", new BigDecimal("20"), RiskType.WATER);
        PolicySubObject so8 = new PolicySubObject("Voodoo Doll House", new BigDecimal("20"), RiskType.WATER);
        PolicySubObject so9 = new PolicySubObject("Adams Jacket", new BigDecimal("20"), RiskType.WATER);

        PolicyObject po3 = new PolicyObject("The Studio");
        PolicyObject po4 = new PolicyObject("The Attic");

        po3.addSubObject(so5);
        po4.addSubObject(so6);
        po4.addSubObject(so7);
        po4.addSubObject(so8);
        po4.addSubObject(so9);
        Policy p5 = new Policy("Some_long_Number_005", Status.APPROVED);
        p5.addObject(po3);
        p5.addObject(po4);
        assertEquals(new BigDecimal("5.00"), PremiumCalculator.calculate(p5));
    }

    @Test
    public void fireLow() {
        PolicySubObject so5 = new PolicySubObject("Safety Matches", new BigDecimal("2"), RiskType.FIRE);
        PolicySubObject so6 = new PolicySubObject("The Horoscope", new BigDecimal("4"), RiskType.FIRE);
        PolicySubObject so7 = new PolicySubObject("Firewood", new BigDecimal("1.000"), RiskType.FIRE);
        PolicySubObject so8 = new PolicySubObject("The Blue Notebook", new BigDecimal("1.5"), RiskType.FIRE);
        PolicySubObject so9 = new PolicySubObject("Handmade Candle", new BigDecimal("1.500"), RiskType.FIRE);

        PolicyObject po3 = new PolicyObject("The Studio");
        PolicyObject po4 = new PolicyObject("The Attic");

        po3.addSubObject(so5);
        po4.addSubObject(so6);
        po4.addSubObject(so7);
        po4.addSubObject(so8);
        po4.addSubObject(so9);
        Policy p6 = new Policy("Some_long_Number_006", Status.APPROVED);
        p6.addObject(po3);
        p6.addObject(po4);
        assertEquals(new BigDecimal("0.13"), PremiumCalculator.calculate(p6));
    }

    @Test
    public void fireThreshold() {
        PolicySubObject so5 = new PolicySubObject("The Silk Umbrella", new BigDecimal("20"), RiskType.FIRE);
        PolicySubObject so6 = new PolicySubObject("Chess", new BigDecimal("20"), RiskType.FIRE);
        PolicySubObject so7 = new PolicySubObject("The Armchair", new BigDecimal("20"), RiskType.FIRE);
        PolicySubObject so8 = new PolicySubObject("The Coffee Table", new BigDecimal("20"), RiskType.FIRE);
        PolicySubObject so9 = new PolicySubObject("The Wooden Chandelier", new BigDecimal("20"), RiskType.FIRE);

        PolicyObject po3 = new PolicyObject("The Villa in Naples");
        PolicyObject po4 = new PolicyObject("The Apartment");

        po3.addSubObject(so5);
        po3.addSubObject(so6);
        po3.addSubObject(so7);
        po4.addSubObject(so8);
        po4.addSubObject(so9);
        Policy p7 = new Policy("Some_long_Number_007", Status.APPROVED);
        p7.addObject(po3);
        p7.addObject(po4);
        assertEquals(new BigDecimal("1.30"), PremiumCalculator.calculate(p7));
    }

    @Test
    public void fireHigh() {
        PolicySubObject so5 = new PolicySubObject("Helicopter", new BigDecimal("200000"), RiskType.FIRE);
        PolicySubObject so6 = new PolicySubObject("Boat", new BigDecimal("200000"), RiskType.FIRE);
        PolicySubObject so7 = new PolicySubObject("Motorbike", new BigDecimal("200000"), RiskType.FIRE);
        PolicySubObject so8 = new PolicySubObject("Wines Collection", new BigDecimal("200000"), RiskType.FIRE);
        PolicySubObject so9 = new PolicySubObject("Mosaic", new BigDecimal("200000"), RiskType.FIRE);

        PolicyObject po3 = new PolicyObject("The Garage");
        PolicyObject po4 = new PolicyObject("The Villa");

        po3.addSubObject(so5);
        po3.addSubObject(so6);
        po3.addSubObject(so7);
        po4.addSubObject(so8);
        po4.addSubObject(so9);
        Policy p8 = new Policy("Some_long_Number_008", Status.APPROVED);
        p8.addObject(po3);
        p8.addObject(po4);
        assertEquals(new BigDecimal("23000.00"), PremiumCalculator.calculate(p8));
    }

}
