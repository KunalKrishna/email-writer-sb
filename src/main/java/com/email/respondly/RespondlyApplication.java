package com.email.respondly;

import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping("/welcome")
public class RespondlyApplication {

	public static void main(String[] args) {
		SpringApplication.run(RespondlyApplication.class, args);

//		Client client = Client.builder().apiKey("AIzaSyDvP33MKX8-KK3LiYA_hVS51zDm8Z05Vzo").build();
//		GenerateContentResponse response =
//				client.models.generateContent(
//						"gemini-2.5-flash",
//						"Explain how AI works in a few words",
//						null);
//		System.out.println(response.text());


		// The client gets the API key from the environment variable `GOOGLE_API_KEY`.
//		Client client = new Client();
//		GenerateContentResponse response =
//				client.models.generateContent(
//						"gemini-2.5-flash",
//						"Explain how AI works in a few words",
//						null);
//		System.out.println(response.text());

	}

	@GetMapping("/home")
	public String welcome() {
		return "Welcome to Respondly!";
	}

}
