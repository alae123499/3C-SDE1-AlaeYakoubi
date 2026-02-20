package tn.esprit._3sdi1_.alae_yakoubi.devoirexam2.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class MyConfig {
    // Intercept all methods in classes inside your service package
    @Before("execution(* tn.esprit._3sdi1_.alae_yakoubi.devoirexam2.service.*.*(..))")
    public void logBeforeServiceMethods(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("Helloooooo from here !ajouterPromotion");
    }
}