import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import java.util.Scanner;

//@SpringBootApplication
public class QuestionApp {

    public static void main(String[] args) {
        SpringApplication.run(QuestionApp.class, args);
    }

    @Component
    public static class QuestionRunner implements CommandLineRunner {

        @Value("${app.question}")
        private String question;

        @Override
        public void run(String... args) throws Exception {
            Scanner scanner = new Scanner(System.in);

            System.out.println(question);
            String userAnswer = scanner.nextLine();

            System.out.println("You entered: " + userAnswer);
        }
    }
}
