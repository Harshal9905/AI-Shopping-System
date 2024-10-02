package Numetry.AIShoping.AI.Bazaar.configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf().disable() // Disable CSRF for simplicity (Consider enabling in production)
            .authorizeRequests()
                .requestMatchers(
                		"/auth/send-otp",
                		"/auth/verify-otp",
                		"/auth/register",
                		"/product/**",
                		"/tags/**",
                		"/categories/**"
//                		"/product/getAllByCategoryId/{categoryId}"
                		).permitAll() // Public endpoints
                .requestMatchers("/login").not().authenticated() // Prevent access to login if already authenticated
 
                .anyRequest().authenticated() // All other endpoints require authentication
            .and()
            .formLogin()
                .loginPage("/login") // Login page URL
                .defaultSuccessUrl("/dashboard", true) // Redirect to dashboard on successful login
                .failureUrl("/login?error=true") // Redirect to login with error parameter onge failure
                .permitAll()
            .and()
            .logout()
                .logoutUrl("/logout") // URL to trigger logout
                .logoutSuccessUrl("/login?logout=true") // Redirect to login page after logout
                .permitAll();

        return http.build();
    }
}
