package aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class LoggingAspect {

    private Logger LOGGER = Logger.getLogger(getClass().getName());


    @Pointcut("execution(* controller.*.*(..))")
    private void forControllerPackage() {

    }

    @Pointcut("execution(* service.*.*(..))")
    private void forServicePackage() {

    }

    @Pointcut("execution(* *.dao.*.*(..))")
    private void forDaoPackage() {

    }

    @Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
    private void forAppFlow() {

    }

    @Before("forAppFlow()")
    public void before(JoinPoint joinPoint) {
        LOGGER.info("=====> @Before IN METHOD " + joinPoint.getSignature().toShortString());
        for (Object arg : joinPoint.getArgs()) {
            LOGGER.info("ARG: " + arg.toString());
        }
    }

    @AfterReturning(pointcut = "forAppFlow()",
            returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result) {
        LOGGER.info("==> @AfterReturning" + joinPoint.getSignature().toShortString());
        LOGGER.info("==> Result: " + result);
    }
}
