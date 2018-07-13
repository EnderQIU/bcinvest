package cn.enderqiu.bcinvestrebuild.permission;

import java.lang.annotation.*;

/**
 * Usage: Split user types (presented as permissions) by commas.
 *        Possible permissions are bank, authority, company
 * Example:
 * // @RequiredPermissions("bank")
 * // @RequiredPermissions("bank, authority")
 * // @RequiredPermissions("company, bank, authority")
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface RequiredPermissions {
    String value();
}
