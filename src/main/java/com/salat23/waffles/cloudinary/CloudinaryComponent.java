package com.salat23.waffles.cloudinary;

import com.cloudinary.Cloudinary;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class CloudinaryComponent {

    @Value("${salat23.app.cloudinary-key}")
    private String cloudinaryKey;
    @Value("${salat23.app.cloudinary-name}")
    private String cloudinaryName;
    @Value("${salat23.app.cloudinary-secret}")
    private String cloudinarySecret;

    @Bean
    public Cloudinary cloudinaryConfig() {
        Cloudinary cloudinary;
        Map<String, String> config = new HashMap<>();
        config.put("cloud_name", cloudinaryName);
        config.put("api_key", cloudinaryKey);
        config.put("api_secret", cloudinarySecret);
        cloudinary = new Cloudinary(config);

        return cloudinary;
    }

}
