package product.price.watcher.infrastructure;


import org.springframework.beans.BeansException;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;

@Component
public class DomainRegistry implements ApplicationContextAware {

    private static ApplicationContext springContext;

    private static Map<Class, Object> objectMap = null;

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        if (springContext == null) {
            springContext = applicationContext;
        }
    }

    public static <T> T bean(Class<T> classz) {

        T bean;
        if (Objects.nonNull(springContext)) {
            try {
                bean = springContext.getBean(classz);
            } catch (NoSuchBeanDefinitionException ex) { bean = null; }
        } else {
            bean = null;
        }

        if (Objects.isNull(bean) && Objects.nonNull(findBean(classz))) {
            return findBean(classz);
        }

        return bean;

    }

    /**
     * 给写单元测试的时候使用，仅允许构建一次。
     *
     * @param initFunction
     */
    public static void initBeans(Function<Map<Class, Object>, Map<Class, Object>> initFunction) {

        if (objectMap == null) {
            objectMap = initFunction.apply(new HashMap<>());
        }

    }

    private static <T> T findBean(Class<T> classz) {

        // 说明没有初始化
        if (Objects.isNull(objectMap)) {
            return null;
        }

        Optional<Map.Entry<Class, Object>> any = objectMap
                .entrySet()
                .stream()
                .filter(it -> classz.isAssignableFrom(it.getKey()))
                .findAny();

        return any.map(classObjectEntry -> (T) classObjectEntry.getValue()).orElse(null);

    }

}

