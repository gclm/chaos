package club.gclmit.chaos.annotation.version;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <p>
 * Swagger API 版本注解
 * </p>
 *
 * @author: gclm
 * @date: 2020/4/1 9:53 PM
 * @version: V1.0
 * @since 1.8
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
public @interface SwaggerApiVersion {

    /**
     * 标识版本号，从v1开始
     */
    String[] value();

}