package com.epam.mentoring.springboot.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import java.beans.PropertyVetoException;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.ui.context.support.ResourceBundleThemeSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.theme.CookieThemeResolver;
import org.springframework.web.servlet.theme.ThemeChangeInterceptor;

@Configuration
@PropertySource(value = {"classpath:jdbc.properties"})
public class WebConfig extends WebMvcConfigurerAdapter {

  @Autowired
  private Environment env;

  @Bean("messageSource")
  public MessageSource messageSource() {
    ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
    messageSource.setBasenames("languages/messages", "messages");
    messageSource.setDefaultEncoding("UTF-8");
    return messageSource;
  }

  @Bean
  public LocaleResolver localeResolver() {
    return new CookieLocaleResolver();
  }

  @Bean
  public ComboPooledDataSource dataSource() {
    ComboPooledDataSource dataSource = new ComboPooledDataSource("jupiter");
    final String DB_DRIVER  = env.getRequiredProperty("jdbc.driverClassName");
    final String DB_URL  = env.getRequiredProperty("jdbc.url");
    final String DB_USERNAME  = env.getRequiredProperty("jdbc.username");
    final String DB_PASSWORD  = env.getRequiredProperty("jdbc.password");
    final String CONN_POOL_MIN_SIZE  = env.getRequiredProperty("c3po.db_conn_pool_min_size");
    final String CONN_POOL_MAX_SIZE  = env.getRequiredProperty("c3po.conn_pool_max_size");
    final String CONN_POOL_IDLE_PERIOD  = env.getRequiredProperty("c3po.conn_pool_idle_period");
    try {
      dataSource.setDriverClass(DB_DRIVER);
    } catch (PropertyVetoException pve){
      System.out.println("Cannot load datasource driver (" + DB_DRIVER +") : " + pve.getMessage());
      return null;
    }
    dataSource.setJdbcUrl(DB_URL);
    dataSource.setUser(DB_USERNAME);
    dataSource.setPassword(DB_PASSWORD);
    dataSource.setMinPoolSize(Integer.parseInt(CONN_POOL_MIN_SIZE));
    dataSource.setMaxPoolSize(Integer.parseInt(CONN_POOL_MAX_SIZE));
    dataSource.setMaxIdleTime(Integer.parseInt(CONN_POOL_IDLE_PERIOD));
    return dataSource;
  }
  @Bean
  public JdbcTemplate jdbcTemplate(DataSource dataSource) {
    JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
    jdbcTemplate.setResultsMapCaseInsensitive(true);
    return jdbcTemplate;
  }

  @Bean
  public JdbcTemplate jdbcTemplate() {
    JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource());
    jdbcTemplate.setResultsMapCaseInsensitive(true);
    return jdbcTemplate;
  }




  @Bean
  public CookieThemeResolver themeResolver() {
    CookieThemeResolver resolver = new CookieThemeResolver();
    resolver.setDefaultThemeName("bright");
    resolver.setCookieName("my-theme-cookie");
    return resolver;
  }

  @Bean
  public ResourceBundleThemeSource themeSource() {
    ResourceBundleThemeSource themeSource = new ResourceBundleThemeSource();
    themeSource.setDefaultEncoding("UTF-8");
    themeSource.setBasenamePrefix("themes.");
    return themeSource;
  }

  @Bean
  public ThemeChangeInterceptor themeChangeInterceptor() {
    ThemeChangeInterceptor interceptor = new ThemeChangeInterceptor();
    interceptor.setParamName("theme");
    return interceptor;
  }

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
    localeChangeInterceptor.setParamName("lang");
    registry.addInterceptor(localeChangeInterceptor);
    registry.addInterceptor(themeChangeInterceptor());
  }

  @Override
  public void addResourceHandlers(final ResourceHandlerRegistry registry) {
    registry.addResourceHandler("/themes/**").addResourceLocations("/themes/");
  }
}
