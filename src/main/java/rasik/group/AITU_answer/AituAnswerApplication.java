package rasik.group.AITU_answer;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableEncryptableProperties
@SpringBootApplication
public class AituAnswerApplication {

	public static void main(String[] args) {

		SpringApplication.run(AituAnswerApplication.class, args);
	}

}
