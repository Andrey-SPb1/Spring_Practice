package org.andrey.spring.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
@Aspect
@Component
public class CommonPointcuts {

    // @within - check annotation on the class level
    @Pointcut("@within(org.springframework.stereotype.Controller)")
    public void isControllerLayer() {
    }

    // within - check class type name
    @Pointcut("within(org.andrey.spring.service.*Service)")
    public void isServiceLayer() {
    }

}
