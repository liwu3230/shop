package org.example.backend.common.config;

import com.google.common.collect.Lists;
import org.example.backend.common.model.enums.TokenType;
import org.example.backend.common.security.jwt.JwtTokenUtil;
import org.example.backend.common.utils.TokenUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.annotation.Resource;
import java.util.List;

@Configuration
@EnableSwagger2
public class Swagger2Config implements WebMvcConfigurer {

    @Resource
    private SwaggerProperties swaggerProperties;

    @Bean
    public Docket createRestApi() {
        List<Parameter> parameters = getParameters();
        return new Docket(DocumentationType.SWAGGER_2)
                .enable(swaggerProperties.getEnable())
                .apiInfo(apiInfo())
                .host(swaggerProperties.getTryHost())
                .select()
                .apis(RequestHandlerSelectors.basePackage("org.example.backend"))
                .paths(PathSelectors.any())
                .build()
                .globalOperationParameters(parameters);
    }

    private List<Parameter> getParameters() {
        String token = JwtTokenUtil.generateNotExpiredToken(TokenType.WEB, 1, "admin", "超级管理员");
        Parameter parameter = new ParameterBuilder()
                .name("Authorization")
                .description("token")
                .modelRef(new ModelRef("string"))
                .parameterType("header")
                .defaultValue(TokenUtil.BEARER_TYPE + " " + token)
                .required(false)
                .build();

        List<Parameter> parameters = Lists.newArrayList();
        parameters.add(parameter);
        return parameters;
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title(swaggerProperties.getApplicationName() + " Api Doc")
                .description(swaggerProperties.getApplicationDescription())
                .contact(new Contact("Backend", null, ""))
                .version(swaggerProperties.getApplicationVersion())
                .build();
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/", "/static", "/public");

        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }

}
