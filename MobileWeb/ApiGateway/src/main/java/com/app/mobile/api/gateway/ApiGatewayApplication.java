package com.app.mobile.api.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;





//@OpenAPIDefinition(info = @Info(title = "REST API", version = "1.0",
//description = "REST API description...",
//contact = @Contact(name = "Name Surname")),
//security = {@SecurityRequirement(name = "bearerToken")}
//)


//@OpenAPIDefinition(info =
//@Info(title = "Employee API", version = "1.0", description = "Documentation Employee API v1.0")
//)
//
//
//@Tag(name = "Rest Controller Name", description = "Description of rest controller functionality.")
@SpringBootApplication
//@EnableAutoConfiguration
//@EnableWebFlux
public class ApiGatewayApplication {
//	@Autowired
//	RouteDefinitionLocator locator;
	
	
	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayApplication.class, args);
	}
	
	
//	@Bean
//	public List<GroupedOpenApi> apis() {
//	   List<GroupedOpenApi> groups = new ArrayList<>();
//	   List<RouteDefinition> definitions = locator.getRouteDefinitions().collectList().block();
//	   definitions.stream().filter(routeDefinition -> routeDefinition.getId().matches(".*-service")).forEach(routeDefinition -> {
//	      String name = routeDefinition.getId().replaceAll("-service", "");
//	      GroupedOpenApi.builder().pathsToMatch("/" + name + "/**").group(name).build();
//	   });
//	   return groups;
//	}
	
	
	
	
	
}
