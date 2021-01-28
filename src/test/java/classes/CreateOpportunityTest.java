package classes;

import enums.Product;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static classes.CreateOpportunity.isValidTruckNumber;
import static org.junit.jupiter.api.Assertions.*;

class CreateOpportunityTest {

    @Test
    void create_correct_hybrid_truck_on_opportunity() {
        Product product = CreateOpportunity.enterCorrectType(new Scanner("hybrid"));

        assertEquals(Product.HYBRID, product);
    }

    @Test
    void create_correct_hybrid_mayus_truck_on_opportunity() {
        Product product = CreateOpportunity.enterCorrectType(new Scanner("HYBRID"));

        assertEquals(Product.HYBRID, product);
    }

    @Test
    void create_correct_flatbed_truck_on_opportunity() {
        Product product = CreateOpportunity.enterCorrectType(new Scanner("flatbed"));

        assertEquals(Product.FLATBED, product);
    }

    @Test
    void create_correct_flatbed_mayus_truck_on_opportunity() {
        Product product = CreateOpportunity.enterCorrectType(new Scanner("FLATBED"));

        assertEquals(Product.FLATBED, product);
    }

    @Test
    void create_correct_box_truck_on_opportunity() {
        Product product = CreateOpportunity.enterCorrectType(new Scanner("box"));

        assertEquals(Product.BOX, product);
    }

    @Test
    void create_correct_box_mayus_truck_on_opportunity() {
        Product product = CreateOpportunity.enterCorrectType(new Scanner("BOX"));

        assertEquals(Product.BOX, product);
    }

    @Test
    void incorrect_get_number_trucks() {
        assertFalse(isValidTruckNumber(-5));
        assertTrue(isValidTruckNumber(15));
    }

}