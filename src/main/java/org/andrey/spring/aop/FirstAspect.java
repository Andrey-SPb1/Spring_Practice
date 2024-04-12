package org.andrey.spring.aop;

import org.andrey.spring.validation.UserInfo;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Aspect
@Component
public class FirstAspect {

    // @within - check annotation on the class level
    @Pointcut("@within(org.springframework.stereotype.Controller)")
    public void isControllerLayer() {
    }

    // within - check class type name
    @Pointcut("within(org.andrey.spring.service.*Service)")
    public void isServiceLayer() {
    }

    /*
        this - check AOP proxy type class
        target - check target object class type
     */
    @Pointcut("this(org.springframework.data.repository.Repository)")
//    @Pointcut("target(org.springframework.data.repository.Repository)")
    public void isRepositoryLayer() {
    }

    // @annotation - check annotation on the method level
    @Pointcut("isControllerLayer() && @annotation(org.springframework.web.bind.annotation.GetMapping)")
    public void hasGetMapping() {
    }

    /*
        args - check method param type
        * - any param type
        .. - 0+ any params type
     */
    @Pointcut("isControllerLayer() && args(org.springframework.ui.Model,..)")
    public void hasModelParam() {
    }

    /*
        args - check annotation on the param type
        * - any param type
        .. - 0+ any params type
     */

    @Pointcut("isControllerLayer() && @args(org.andrey.spring.validation.UserInfo)")
    public void hasUserInfoParamAnnotation() {
    }

    // bean - check bean name
    @Pointcut("bean(*Service)")
    public void isServiceLayerBean() {
    }

    // execution(modifiers-pattern? ret-type-pattern declaring-type-pattern?name-pattern(param-pattern) throws-pattern?)
    @Pointcut("execution(public * org.andrey.spring.service.*Service.findById(*))")
    public void anyFindByIdServiceMethod() {
    }























}
