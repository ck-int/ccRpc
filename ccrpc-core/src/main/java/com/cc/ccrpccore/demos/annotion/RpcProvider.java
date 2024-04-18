package com.cc.ccrpccore.demos.annotion;

import java.lang.annotation.*;

/**
 * rpc提供者注解
 * @author ck
 */
@Documented //javadoc 文档化
@Retention(RetentionPolicy.RUNTIME) //作用时机 运行时
@Target(ElementType.TYPE) //放在类上
@Inherited //允许继承
public @interface RpcProvider {
}
