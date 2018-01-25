package matera.systems.cursoferias2018.api.conf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({ 
	"matera.systems.cursoferias2018.api.resources", 
	"matera.systems.cursoferias2018.api.domain" 
})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
