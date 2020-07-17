package local.kmcgeeka.javazoosweb31;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class Javazoosweb31Application
{

    public static void main(String[] args)
    {
        SpringApplication.run(Javazoosweb31Application.class, args);
    }

}
