package com.email.respondly;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/api/email")
//TODO: Review CORS settings for security
@CrossOrigin(origins = "*")
public class EmailGeneratorController {

    private final EmailGenerationService emailGenerationService;

    @Autowired
    public EmailGeneratorController(EmailGenerationService emailGenerationService) {
        this.emailGenerationService = emailGenerationService;
    }

    @PostMapping("/generate-reply")
//    @CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.POST, RequestMethod.OPTIONS})
    public ResponseEntity<String> generateEmail(@RequestBody EmailRequest emailRequest) {

        String generatedEmailResponse = emailGenerationService.generateEmail(emailRequest); // a generated email based on the request
        return ResponseEntity.ok(generatedEmailResponse);
    }
}
