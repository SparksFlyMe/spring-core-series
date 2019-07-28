package com.kaizhang.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

import java.util.Arrays;

/**
 * @author ：kaizhang
 * @date ：2019/7/23 23:04
 * @description： 切面类
 */
@Aspect
public class LogAspects {
    /**
     * 抽取公共的切入点表达式
     * 1、本类引用：直接用方法名，比如pointCut()
     * 2、其他的切面引用：写入应用类的全名：com.kaizhang.config.LogAspects.pointCut()
     */
    @Pointcut("execution(public int com.kaizhang.demo.MathCalculator.*(..))")
    public void pointCut() {

    }


    /**
     * @Before在目标方法之前切入，切入点表达式（指定在哪个方法切入） 如果 @Before("execution(public int com.kaizhang.demo.MathCalculator..*(..))")表示切这个类的所有方法
     */
//    @Before("execution(public int com.kaizhang.demo.MathCalculator.div(int, int))")
    @Before(value = "execution(public int com.kaizhang.demo.MathCalculator..*(..))")
    public void logStart(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        System.out.println("" + joinPoint.getSignature().getName() + "运行。。。@Before参数列表是：{" + Arrays.asList(args) + "}");
    }

    @After("pointCut()")// 公共切入点表达式本类引用
    public void logEnd(JoinPoint joinPoint) {
        System.out.println("" + joinPoint.getSignature().getName() + "结束。。。@After参数列表是：{}");
    }

    // 注意，JoinPoint如果要写，必须出现在参数的第一位
    @AfterReturning(value = "com.kaizhang.config.LogAspects.pointCut()", returning = "result")// 引入其他类的公共切入点表达式
    public void logReturn(JoinPoint joinPoint, Object result) {
        System.out.println("" + joinPoint.getSignature().getName() + "正常返回。。。@AfterReturning运行结果：{" + result + "}");
    }

    @AfterThrowing(value = "pointCut()", throwing = "exception")
    public void logException(JoinPoint joinPoint, Exception exception) {
        System.out.println("" + joinPoint.getSignature().getName() + "除法异常。。。@AfterThrowing运异常信息：{" + exception + "}");
    }
}
