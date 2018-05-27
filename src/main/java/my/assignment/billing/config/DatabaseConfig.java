package my.assignment.billing.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * Created by bkothari on 26/05/18.
 */
@Configuration
public class DatabaseConfig {

    @Value("${spring.datasource.type}")
    private String datasourceType;

    @Value("${spring.datasource.url}")
    private String url;

    @Value("${spring.datasource.driver-class-name}")
    private String driverClassName;

    @Value("${spring.datasource.username}")
    private String userName;

    @Value("${spring.datasource.password}")
    private String password;

    private DataSource dataSource;

    @Bean(name = "dataSource")
    public DataSource dataSource() {
        if(dataSource == null) {
            dataSource = DataSourceBuilder.create()
                    .type(HikariDataSource.class)
                    .username(userName)
                    .password(password)
                    .url(url)
                    .driverClassName(driverClassName)
                    .build();
        }
        return dataSource;
    }
}


