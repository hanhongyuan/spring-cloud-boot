package com.example.sbmp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @email wangiegie@gmail.com
 * @data 2017-08
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private HAuthenticationProvider provider;//自定义验证
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/", "/home").permitAll()//不需要验证的URL
                .antMatchers("/admin/**").hasRole("ADMIN")//“/admin/”开头的URL必须要是管理员用户，譬如”admin”用户
                .anyRequest().authenticated()// 所有其他的URL都需要用户进行验证
                .and()
                .formLogin()
                .loginPage("/login") //使用Java配置默认值设置了基于表单的验证。使用POST提交到”/login”时，需要用”username”和”password”进行验证。
                .permitAll()
                .and()
                .logout()
                .permitAll();
    }

    /**
     * 忽略某些请求。
     */
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/js/**", "/css/**", "/images/**", "/**/favicon.ico");
    }

    /**
     * 用户授权
     */
    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
    	 //将验证过程交给自定义验证工具
        auth.authenticationProvider(provider);
        //auth.inMemoryAuthentication().withUser("user").password("root").roles("USER");
    }
}
