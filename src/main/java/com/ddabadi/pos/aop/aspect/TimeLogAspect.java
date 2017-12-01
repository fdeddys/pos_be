package com.ddabadi.pos.aop.aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: deddy
 * Date: 11/19/17
 * Time: 8:43 PM
 * To change this template use File | Settings | File Templates.
 */
@Aspect
@Component
public class TimeLogAspect {

    final Logger logger=Logger.getLogger(TimeLogAspect.class);

    // && execution(public * *(..)
    // @annotation(com.ddabadi.pos.aop.Timed) &&
//    @Around("@annotation(com.ddabadi.pos.aop.Timed) && execution(public * *(..))")
//    public Object timeExecution(final ProceedingJoinPoint joinPoint) throws Throwable {
//        long waktuMulai = System.currentTimeMillis();
//
//        logger.info("AOP Controller = [" + joinPoint.getSignature().getDeclaringType().getName() + "] Function [" +
//                joinPoint.getSignature().getName() +"] " );
//        logger.info("==> waktu mulai =" + waktuMulai);
//        Object hasil;
//
//        try{
//            hasil = joinPoint.proceed();
//
//        }catch (Throwable throwable){
//            throw throwable;
//        } finally {
//            long totalWaktu = waktuMulai - System.currentTimeMillis();
//            logger.info("==> waktu exec selama = " + totalWaktu + "s " );
//        }
//        return hasil;
//    }
//
//    @Before("execution(public * com.ddabadi.pos.service.impl.*.*(org.springframework.data.domain.PageRequest)) && args(page)")
//    public void beforeGet(org.springframework.data.domain.PageRequest page){
//        logger.info("AOP Before sebelum Service");
//    }
//
//    @Around("@annotation(org.springframework.web.bind.annotation.RequestMapping) && execution(public * *(..))")
//    public Object log(final ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
//        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
//                .currentRequestAttributes())
//                .getRequest();
//
//        Object value;
//        logger.info(
//                "AOP via Rest Controller [" +
//                        request.getMethod() + "] URI ["+
//                        request.getRequestURI() + "] Address [" +
//                        request.getRemoteAddr()+ "] Http Header -> {'user-id'} : {'" +
//                        request.getHeader("user-id") +"'} ");
//
//        try {
//            value = proceedingJoinPoint.proceed();
//            //throw new Exception("error");
//        } catch (Throwable throwable) {
//            throw throwable;
//        } finally {
//
//        }
//
//        return value;
//    }

    @Pointcut("within(com.ddabadi.pos.rest)")
    public void pointcutRest(){

    }

    @Pointcut("within(com.ddabadi.pos.service)")
    public void pointcutService(){

    }

    //@Around("pointcutRest() || pointcutService() ")
    @Around("@annotation(com.ddabadi.pos.aop.Timed)")
    public Object adviceJoinPointProccessTimed(ProceedingJoinPoint proceedingJoinPoint){
        String nama = proceedingJoinPoint.getSignature().getName();
        Object[] params = proceedingJoinPoint.getArgs();
        String parameter = this.iterateParam(params);

        logger.info("Jointpoint ["+nama+"] Start = " + new Date() + " Params [" + parameter + "] ");
        Object hasil = null;
        try {
            hasil = proceedingJoinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } finally {
            logger.info("Jointpoint [" + nama + "] Finish = " + new Date());
        }
        return hasil;

    };

    private String iterateParam(Object[]params){
        StringBuilder sb = new StringBuilder();

        if(params.length>0){
            for(Object  param : params){
                if(sb.length()>0){
                    sb.append(", ");
                }
                sb.append(param);
            }
        }

        return sb.toString();
    }

}
