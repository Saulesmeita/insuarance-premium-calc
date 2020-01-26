#### Implementation Description

Functionality that calculates policy premium has been created

##### Premium calculation formula:
```
PREMIUM = PREMIUM_FIRE + PREMIUM_WATER 
PREMIUM_FIRE = SUM_INSURED_FIRE * COEFFICIENT_FIRE 
SUM_INSURED_FIRE - total sum insured of all policy's sub-objects with type "Fire" COEFFICIENT_FIRE - by default 0.013 
but if SUM_INSURED_FIRE is over 100 then 0.023 PREMIUM_WATER = SUM_INSURED_WATER * COEFFICIENT_WATER 
SUM_INSURED_WATER - total sum insured of all policy's sub-objects with type "Water" COEFFICIENT_WATER - by default 0.1
but if SUM_INSURED_WATER equal or greater than 10 then 0.05 
```
All necessary entities (Policy, Policy Object and Policy Sub-Object) were constructed so that they hold their own information and are able to make calculations of the fields of their sub-objects.

No field validation has been developed for the objects - it was assumed that Premium Calculator class receives ready objects via API.

Enum classes were used to store Risk Types and Policy Status, that guarantees easy addition of new risk types and statuses.

##### The functionality invocation: 

```
    PremiumCalculator.calculate(Policy policy)
```
The demonstration of the functionality is available at the "test" directory. Please run the unit tests.

##### Technologies:

- Java 8+
- jUnit 4 