package za.com.iqbusiness;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

@SpringBootApplication(scanBasePackages = {"za.com"})
@EnableJpaAuditing
@EnableSwagger2
public class PersonApplication extends SpringBootServletInitializer {

		@Override
		protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
			return application.sources(PersonApplication.class);
		}

	public static void main(String[] args) {
		SpringApplication.run(PersonApplication.class, args);
	}

	// swagger configuration.
	@Bean
	public Docket configureSwagger() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(new ApiInfoBuilder().description("This Micorservice " +
				"serves" + " iqbusiness").title("iqbusiness").version("1.0").build()).select().paths(regex("/v1.*")).build();
	}

}
