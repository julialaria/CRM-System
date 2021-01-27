package classes;

import org.apache.commons.validator.routines.EmailValidator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LeadTest {
    private Lead lead;

    @Test
    void isPhoneNumberValid_validPhone_True() {
        assertTrue(Lead.isPhoneNumberValid("666222333"));
        assertTrue(Lead.isPhoneNumberValid("666-222-333"));
        assertTrue(Lead.isPhoneNumberValid("666 222 333"));
        assertTrue(Lead.isPhoneNumberValid("666 22 23 33"));
    }

    @Test
    void isPhoneNumberValid_invalidPhone_IllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, ()->Lead.isPhoneNumberValid("6662223334"));
        assertThrows(IllegalArgumentException.class, ()->Lead.isPhoneNumberValid("662abc659"));
    }

    @Test
    void isEmailValid_validEmail_True() {
        assertTrue(Lead.isEmailValid("javier123@gmail.com"));
        assertTrue(Lead.isEmailValid("javier1d23@hotmail.com"));
        assertTrue(Lead.isEmailValid("javier1d23@hotmail.es"));
    }

    @Test
    void isEmailValid_invalidEmail_IllegalArgumentException() {
        assertThrows(IllegalArgumentException.class,()->Lead.isEmailValid("javier123@@mail.com"));
        assertThrows(IllegalArgumentException.class,()->Lead.isEmailValid("javier123@mail..es"));
        assertThrows(IllegalArgumentException.class,()->Lead.isEmailValid("javier123gmail.com"));
        assertThrows(IllegalArgumentException.class,()->Lead.isEmailValid("javier123@gmail."));
    }


}