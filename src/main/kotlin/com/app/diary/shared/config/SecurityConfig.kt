package com.app.diary.shared.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.Customizer
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.web.SecurityFilterChain
import org.springframework.web.cors.CorsUtils

@Configuration
@EnableWebSecurity
class SecurityConfig {

    @Bean
    fun filterChain(http: HttpSecurity): SecurityFilterChain =
        http
            .cors(Customizer.withDefaults())
            .csrf { it.disable() }
            .httpBasic() { it.disable() }
            .formLogin() { it.disable() }
            .sessionManagement() { it.sessionCreationPolicy(SessionCreationPolicy.STATELESS) }
            .authorizeHttpRequests() {
                it.requestMatchers(CorsUtils::isPreFlightRequest).permitAll()
                    .anyRequest().permitAll()
            }
            .build()
}