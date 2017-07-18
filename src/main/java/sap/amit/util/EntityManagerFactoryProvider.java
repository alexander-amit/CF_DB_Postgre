package sap.amit.util;


//import static org.eclipse.persistence.config.PersistenceUnitProperties.CACHE_SHARED_DEFAULT;
//import static org.eclipse.persistence.config.PersistenceUnitProperties.CLASSLOADER;
//import static org.eclipse.persistence.config.PersistenceUnitProperties.CREATE_OR_EXTEND;
//import static org.eclipse.persistence.config.PersistenceUnitProperties.DDL_GENERATION_MODE;
//import static org.eclipse.persistence.config.PersistenceUnitProperties.*;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.eclipse.persistence.jpa.PersistenceProvider;
import org.springframework.instrument.classloading.SimpleLoadTimeWeaver;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.EclipseLinkJpaVendorAdapter;

public class EntityManagerFactoryProvider {

    public static LocalContainerEntityManagerFactoryBean get(DataSource dataSource, String... packagesToScan) {

        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();

        entityManagerFactoryBean.setPersistenceProvider(new PersistenceProvider());
        entityManagerFactoryBean.setPackagesToScan(packagesToScan);
        entityManagerFactoryBean.setDataSource(dataSource);

        entityManagerFactoryBean.setJpaPropertyMap(getJPAProperties(dataSource.getClass().getClassLoader()));
        entityManagerFactoryBean.setLoadTimeWeaver(new SimpleLoadTimeWeaver());
        entityManagerFactoryBean.setJpaVendorAdapter(new EclipseLinkJpaVendorAdapter());
        
        entityManagerFactoryBean.afterPropertiesSet();

        return entityManagerFactoryBean;
    }

   private static Map<String, Object> getJPAProperties(ClassLoader classLoader) {
        Map<String, Object> properties = new HashMap<>();

        properties.put("eclipselink.classloader", "create-or-extend-tables");
        properties.put("eclipselink.ddl-generation.output-mode", "database");
        properties.put("eclipselink.classloader", classLoader);
        properties.put("eclipselink.logging.level", "INFO"); // "FINE" provides more details

        // do not cache entities locally, as this causes problems if multiple application instances are used
        properties.put("eclipselink.cache.shared.default", "false");

        return properties;
    }
}
