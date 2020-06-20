package home;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AopStart.class)
public class TestAop {
    @Test
    @Ignore
    public void testAop1() { // 此方法不需要 @RunWith 和 @ContextConfiguration
        AnnotationConfigApplicationContext app = new AnnotationConfigApplicationContext(AopStart.class);

        MathDivide m = app.getBean(MathDivide.class);
        m.divide(100, 100);

        app.close();
    }

    @Autowired
    private MathDivide div;

    @Test
    public void testAop2() {
        div.divide(100, 100);
    }
}
