package home;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@EnableAspectJAutoProxy // 會自動找有 @Aspect 的註解
@Component
@ComponentScan("home")
public class AopStart {
}
