package home;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@EnableAspectJAutoProxy // �|�۰ʧ䦳 @Aspect ������
@Component
@ComponentScan("home")
public class AopStart {
}
