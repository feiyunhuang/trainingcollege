package cn.edu.nju.trainingcollege;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class TrainingcollegeApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrainingcollegeApplication.class, args);
	}
}
