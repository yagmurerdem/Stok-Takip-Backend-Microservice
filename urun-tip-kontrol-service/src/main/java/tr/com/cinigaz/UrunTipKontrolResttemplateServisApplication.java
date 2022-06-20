package tr.com.cinigaz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class UrunTipKontrolResttemplateServisApplication {

	public static void main(String[] args) {
		SpringApplication.run(UrunTipKontrolResttemplateServisApplication.class, args);
	}

	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}


}
