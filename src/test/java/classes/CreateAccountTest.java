package classes;

import enums.Industry;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static classes.CreateAccount.enterCorrectIndustry;
import static classes.CreateAccount.getEmployees;
import static org.junit.jupiter.api.Assertions.*;

class CreateAccountTest {

    @Test
    void create_correct_industry_on_account() {
        String input = "PRODUCE";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Industry industry = enterCorrectIndustry();

        assertEquals(Industry.PRODUCE, industry);
    }

    @Test
    void create_correct_employees_on_account() {
        String input = "10";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        int employees = getEmployees();

        assertEquals(10, employees);
    }

    @AfterEach
    void tearDown() {
        String input = "PRODUCE 10";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }
}