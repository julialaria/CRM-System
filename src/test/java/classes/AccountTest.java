package classes;

import enums.Industry;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {
    @Test
    void generate_correct_id() {
        Account account = new Account(Industry.ECOMMERCE,2,"Madrid","España", null, null);
        Account account2 = new Account(Industry.ECOMMERCE,2,"Madrid","España", null, null);
        assertEquals(2, account2.getId());
    }
}