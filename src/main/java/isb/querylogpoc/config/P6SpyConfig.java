package isb.querylogpoc.config;

import com.p6spy.engine.spy.P6DataSource;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class P6SpyConfig implements BeanPostProcessor {

    @Override
    public Object postProcessAfterInitialization(final Object bean, final String beanName) throws BeansException {
        if (bean instanceof DataSource) {
            DataSource dataSourceBean = (DataSource) bean;
            return new P6DataSource(dataSourceBean);
        }
        return bean;
    }
}
