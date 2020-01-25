package entities;

import java.math.BigDecimal;
import java.util.Objects;

public class PolicySubObject {

    private SubObjectName name;
    private BigDecimal sumInsured;
    private RiskType riskType;

    public PolicySubObject(SubObjectName name, BigDecimal sumInsured, RiskType riskType) {
        this.name = name;
        this.sumInsured = sumInsured;
        this.riskType = riskType;
    }

    public SubObjectName getName() {
        return name;
    }

    public void setName(SubObjectName name) {
        this.name = name;
    }

    public BigDecimal getSumInsured() {
        return sumInsured;
    }

    public void setSumInsured(BigDecimal sumInsured) {
        this.sumInsured = sumInsured;
    }

    public RiskType getRiskType() {
        return riskType;
    }

    public void setRiskType(RiskType riskType) {
        this.riskType = riskType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PolicySubObject)) return false;
        PolicySubObject that = (PolicySubObject) o;
        return getName().equals(that.getName()) &&
                getSumInsured().equals(that.getSumInsured()) &&
                getRiskType().equals(that.getRiskType());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRiskType());
    }
}
