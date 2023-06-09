package ru.mirea.cursework.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import ru.mirea.cursework.service.UserServ;

@Configuration
@EnableWebSecurity
public class Security extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserServ userServ;
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()//подключение авторизации
                .antMatchers("/","/reg","/cart","/reviews","/login/**").permitAll() //адреса, на которые будут пускать без регистрации
                .anyRequest().authenticated() //системный шаблонный набор
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
                .logout()
                .permitAll();
        //.and()
        //.csrf()
        //.disable();
    }

    @Override
    public void configure(WebSecurity web) { //подзагрузка css, картинки
        web.ignoring().antMatchers("/resources/**", "/static/**","/js/**" , "/css/**", "/img/**");
    }
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(userServ)
                .passwordEncoder(NoOpPasswordEncoder.getInstance());
    }
}
