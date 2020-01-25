package entities;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class PolicyObject {

    public String name;

    public HashMap<PolicySubObject, RiskType> subObjects = new HashMap<>();

    public PolicyObject(String name) {
        this.name = name;
    }

    public PolicyObject(String name, HashMap<PolicySubObject, RiskType> subObjects) {
        this.name = name;
        this.subObjects = subObjects;
    }

    public void addSubObject(PolicySubObject subObject) {
        subObjects.put(subObject, subObject.getRiskType());
    }

    public void addSubObject(SubObjectName name, BigDecimal sumInsured, RiskType riskType) {
        addSubObject(new PolicySubObject(name, sumInsured, riskType));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HashMap<PolicySubObject, RiskType> getSubObjects() {
        return subObjects;
    }

    public void setSubObjects(HashMap<PolicySubObject, RiskType> subObjects) {
        this.subObjects = subObjects;
    }

    public BigDecimal sumInsuredSubtotal(RiskType riskType) {
        BigDecimal sum = new BigDecimal("0.00");
        for (Map.Entry<PolicySubObject, RiskType> entry : subObjects.entrySet()) {
            if (entry.getValue().equals(riskType)) {
                sum = sum.add(entry.getKey().getSumInsured());
            }
        }
        return sum;
    }
}
