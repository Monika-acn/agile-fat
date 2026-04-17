package com.example.app;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ResetControllerTest {

    ResetController controller = new ResetController();

    @Test
    public void testInvalidOtp() {
        controller.generateOtp("test@example.com");
        String result = controller.resetPassword("test@example.com", "000000", "newPass");
        assertEquals("Invalid OTP", result);
    }

    @Test
    public void testNoOtpRequest() {
        String result = controller.resetPassword("unknown@example.com", "123456", "newPass");
        assertEquals("No OTP request found for this email", result);
    }

    @Test
    public void testGenerateOtp() {
        String result = controller.generateOtp("user@example.com");
        assertTrue(result.contains("OTP sent"));
    }
}
