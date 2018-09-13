
package proje.ogrenci;


import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.persistenceunit.PersistenceUnitManager;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import proje.ogrenci.entities.Ogrenci;
import proje.ogrenci.repository.OgrenciRepository;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackageClasses = OgrenciRepository.class, entityManagerFactoryRef = "ogrenciEntityManagerFactory", transactionManagerRef = "ogrenciTransactionManager")
public class OgrenciDBConfig {


    @Primary
    @Bean
    @ConfigurationProperties("spring.datasource.ogrenci")
    public DataSourceProperties ogrenciDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Primary
    @Bean
    public DataSource ogrenciDataSource(@Qualifier("ogrenciDataSourceProperties") DataSourceProperties ogrenciDataSourceProperties) {
        return ogrenciDataSourceProperties.initializeDataSourceBuilder().build();
    }

    @Primary
    @Bean
    public LocalContainerEntityManagerFactoryBean ogrenciEntityManagerFactory(@Qualifier("ogrenciDataSource") DataSource ogrenciDataSource, EntityManagerFactoryBuilder builder) {
        return builder.dataSource(ogrenciDataSource).packages(Ogrenci.class).persistenceUnit("ogrenciPU").build();
    }

    @Primary
    @Bean
    public PlatformTransactionManager ogrenciTransactionManager(EntityManagerFactory ogrenciEntityManagerFactory) {
        return new JpaTransactionManager(ogrenciEntityManagerFactory);
    }
}
