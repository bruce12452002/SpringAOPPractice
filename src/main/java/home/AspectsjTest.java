package home;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
public class AspectsjTest {

    @Pointcut("execution(public int home.MathDivide.*(..))")
    public void pc() {
    }

    @Before("pc()") // �]�i�N @Pointcut �̪����g�b�o�A�����h�Ӧa��n�ΡA�ҥH���X�ӤF
    public void begin(JoinPoint jp) {
        // jp.getSignature().getName() ����k�W��
        System.out.println("�e�m�q���A�ѼƬ�=" + List.of(jp.getArgs()));
    }

    @After("home.AspectsjTest.pc()") // �p�G pc() �b�ۤv�����O�A�i�H�u�g��k�W�M�A���N�n�F�F �o�ͨҥ~�]�|����
    public void end(JoinPoint jp) {
        System.out.println("��m�q��");
    }

    // JoinPoint �p�G�n�g�A�N�@�w�n�g�b�Ĥ@�ӰѼ�
    @AfterReturning(value = "pc()", returning = "rt")
    public void rtn(JoinPoint jp, Object rt) {
        System.out.println("�^�ǭȳq���A�^�ǭȬ�=" + rt);
    }

    @AfterThrowing(value = "pc()", throwing = "ext")
    public void throwing(JoinPoint jp, Exception ext) {
        System.out.println("�ҥ~�q���A�ҥ~��=" + ext);
    }

    @Around("pc()")
    public void around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("��¶�q���}�l");
        // �� proceed �N���੹�U���Apjp �̦��ܦh�F��A�i�H�P�_�@�ǭȡA�A�M�w�n���n proceed
        pjp.proceed();
        System.out.println("��¶�q������"); // ����o�ͨҥ~���|����
    }
}
