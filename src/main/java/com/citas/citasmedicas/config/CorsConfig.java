package com.citas.citasmedicas.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        //AÑADIR TODAS LAS RUTAS QUE QUIERES USAR (A esta hay q quitarle lo del final)
        registry.addMapping("/especializacion/getAllEspecializaciones")
                .allowedOrigins("http://localhost:8100")
                .allowedMethods("GET", "POST", "PUT", "DELETE")
                .allowCredentials(true);
        //.....
        registry.addMapping("/medico/getAllMedicos")
                .allowedOrigins("http://localhost:8100")
                .allowedMethods("GET", "POST", "PUT", "DELETE")
                .allowCredentials(true);
    }
}

