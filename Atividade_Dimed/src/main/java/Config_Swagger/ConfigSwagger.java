package Config_Swagger;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.config.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import com.google.common.base.Predicate;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class ConfigSwagger extends WebMvcConfigurationSupport {
	
	@Bean
	public Docket ApiDimed() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("Atividade_Dimed/src/main/java"))
				.paths(regex("/itinerario"))
				.build()
				.apiInfo(metaInfo());
	}

	private Predicate<String> regex(String string) {
	
		return null;
	}

	private ApiInfo metaInfo() {
		return new ApiInfoBuilder().title("API FILIPE JEFERSON")
				.description("Api responsável pela manutenção e atualização da mobilidade urbana").version("1.0.0")
				.license("").build();
	}

	protected void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:META-INF/resources/");
		registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:META-INF/resources/webjars/");
	}

}
