package entities;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Policy {

    private String number;
    private Status status;

    private List<PolicyObject> objectsList = new ArrayList<>();
    // Policy objects -- Collection of one or multiple objects
    private BigDecimal premium;
    //Premium -- Client pays this sum for the policy

    public Policy(String number, Status status) {
        this.number = number;
        this.status = status;
    }

    public void addObject(PolicyObject policyObject) {
        objectsList.add(policyObject);
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public List<PolicyObject> getObjectsList() {
        return objectsList;
    }

    public void setObjectsList(List<PolicyObject> objectsList) {
        this.objectsList = objectsList;
    }

    public BigDecimal getPremium() {
        return premium;
    }

    public void setPremium(BigDecimal premium) {
        this.premium = premium;
    }

    public BigDecimal policySumInsuredSubtotal(RiskType riskType) {
        BigDecimal sum = new BigDecimal("0.00");
        for (PolicyObject policyObject : objectsList) {
            sum = sum.add(policyObject.sumInsuredSubtotal(riskType));
        }
        return sum;
    }
}
