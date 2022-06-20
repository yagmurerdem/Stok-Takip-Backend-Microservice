package tr.com.cinigaz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class UrunKontrolResttemplateServisApplication {

	public static void main(String[] args) {
		SpringApplication.run(UrunKontrolResttemplateServisApplication.class, args);
	}

	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}


}
