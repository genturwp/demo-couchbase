package com.konnco.demowebfluxcouchbase;

import com.konnco.demowebfluxcouchbase.domain.UserProfile;
import com.konnco.demowebfluxcouchbase.repository.UserProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.time.Month;

@SpringBootApplication
public class DemoWebfluxCouchbaseApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DemoWebfluxCouchbaseApplication.class, args);
	}

	@Autowired
	private UserProfileRepository userProfileRepository;

	@Override
	public void run(String... args) throws Exception {
		UserProfile up = new UserProfile();
		up.setProfileName("konnco");
		up.setAddress("jl. cempakasari");
		up.setAge(17);
		up.setBodyWeight(60.5);
		up.setBirthDate(LocalDate.of(1990, Month.JANUARY, 1));
		this.userProfileRepository.save(up).subscribe();
	}
}
