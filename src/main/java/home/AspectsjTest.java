package home;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
public class AspectsjTest {

    @Pointcut("execution(public Integer home.MathDivide.*(..))")
    public void pc() {
    }

    @Pointcut("@annotation(home.Bruce)") // 抓 @Bruce
    public void aaa() {
    }

    @Before("pc()") // 也可將 @Pointcut 裡的全寫在這，但有多個地方要用，所以提出來了
    public void begin(JoinPoint jp) {
        // jp.getSignature().getName() 為方法名稱
        System.out.println("前置通知，參數為=" + List.of(jp.getArgs()));
    }

    @After("home.AspectsjTest.pc()") // 如果 pc() 在自己的類別，可以只寫方法名和括號就好了； 發生例外也會執行
    public void end(JoinPoint jp) {
        System.out.println("後置通知");
    }

    // JoinPoint 如果要寫，就一定要寫在第一個參數
    @AfterReturning(value = "pc()", returning = "rt")
    public void rtn(JoinPoint jp, Object rt) {
        System.out.println("回傳值通知，回傳值為=" + rt);
    }

    @AfterThrowing(value = "pc()", throwing = "ext")
    public void throwing(JoinPoint jp, Exception ext) {
        System.out.println("例外通知，例外為=" + ext);
    }

//    @Around("aaa()")
    @Around("pc()")
    public void around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("環繞通知開始");
        // 不 proceed 就不能往下走，pjp 裡有很多東西，可以判斷一些值，再決定要不要 proceed
        pjp.proceed();
        System.out.println("環繞通知結束"); // 此行發生例外不會執行
    }
}
