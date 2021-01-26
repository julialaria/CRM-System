package classes;

import Enums.Product;
import Enums.Status;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.*;

class OpportunityTest {

    Contact contact1 = new Contact();

    Lead lead1 = new Lead ("juan", "656565", "juan@email", "companyName");

    Opportunity opportunity1 = new Opportunity(Product.HYBRID, 230, contact1);



    @org.junit.jupiter.api.Test

    public void convertLeadToOpportunity_LeadProductQuantityDecisionMaker_valid() {

        assertEquals(true, Opportunity.convertLeadToOpportunity (lead1, Product.HYBRID, 230, contact1).equals(opportunity1));

    }

    @org.junit.jupiter.api.Test

    public void convertLeadToOpportunity_negativeQuantity_IllegalArgumentException() {

        assertThrows(IllegalArgumentException.class, () -> Opportunity.convertLeadToOpportunity (lead1,Product.HYBRID,-3,contact1));

    }

    @org.junit.jupiter.api.Test

    public void convertLeadToOpportunity_zeroQuantity_IllegalArgumentException() {

        assertThrows(IllegalArgumentException.class, () -> Opportunity.convertLeadToOpportunity (lead1,Product.HYBRID,0,contact1));
    }


    @org.junit.jupiter.api.Test

    public void changeOpportunityStatus_oneNumber_valid() {

        Opportunity.changeOpportunityStatus(opportunity1, 1);

        assertEquals (Status.CLOSED_WON, opportunity1.getStatus());

    }

    @org.junit.jupiter.api.Test

    public void changeOpportunityStatus_twoNumber_valid() {

        Opportunity.changeOpportunityStatus(opportunity1, 2);

        assertEquals (Status.CLOSED_LOST, opportunity1.getStatus());

    }

    @org.junit.jupiter.api.Test
    public void changeOpportunityStatus_negativeNumber_IllegalArgumentException() {

        assertThrows(IllegalArgumentException.class, () -> Opportunity.changeOpportunityStatus(opportunity1, -5));

    }


    @org.junit.jupiter.api.Test
    public void changeOpportunityStatus_zeroNumber_IllegalArgumentException() {

        assertThrows(IllegalArgumentException.class, () -> Opportunity.changeOpportunityStatus(opportunity1, 0));

    }


    @org.junit.jupiter.api.Test
    public void lookUpOpportunity_opportunity_valid() {


    }
}