package com.example.app;

import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@RestController
@RequestMapping("/api/reset")
public class ResetController {

    private Map<String, String> otpStore = new HashMap<>();

    // Step 1: Generate OTP
    @PostMapping("/generate")
    public String generateOtp(@RequestParam String email) {
        String otp = String.valueOf(100000 + new Random().nextInt(900000));
        otpStore.put(email, otp);
        System.out.println("OTP for " + email + " : " + otp);
        return "OTP sent to " + email;
    }

    // Step 2: Verify OTP and Reset Password
    @PostMapping("/verify")
    public String resetPassword(@RequestParam String email,
                                @RequestParam String otp,
                                @RequestParam String newPassword) {
        if (!otpStore.containsKey(email)) {
            return "No OTP request found for this email";
        }
        if (!otpStore.get(email).equals(otp)) {
            return "Invalid OTP";
        }
        otpStore.remove(email);
        return "Password reset successfully for " + email;
    }

    @GetMapping("/")
    public String home() {
        return "Password Reset System Running!";
    }
}