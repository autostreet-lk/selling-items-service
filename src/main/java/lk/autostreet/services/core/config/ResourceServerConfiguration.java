package lk.autostreet.services.core.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
@EnableResourceServer
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true, jsr250Enabled = true)
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers(HttpMethod.GET, "/brands/{brand-id}/models").permitAll()
                .antMatchers(HttpMethod.POST, "/sellers/{seller-id}/items").permitAll()
                .antMatchers(HttpMethod.GET, "/items/categories").permitAll()
                .antMatchers(HttpMethod.GET, "/items/types").permitAll()
                .antMatchers(HttpMethod.GET, "/items/fuel-types").permitAll()
                .antMatchers(HttpMethod.GET, "/items/transmissions").permitAll()
                .antMatchers(HttpMethod.GET, "/items/conditions").permitAll()
                .antMatchers(HttpMethod.POST, "/items/images").permitAll()
                .anyRequest().authenticated();
    }
}