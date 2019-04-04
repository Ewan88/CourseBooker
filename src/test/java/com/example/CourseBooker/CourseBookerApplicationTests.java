package com.example.CourseBooker;

import com.example.CourseBooker.models.Customer;
import com.example.CourseBooker.repositories.CourseRepository.CourseRepository;
import com.example.CourseBooker.repositories.CustomerRepository.CustomerRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CourseBookerApplicationTests {

	@Autowired
	CustomerRepository customerRepository;


	@Test
	public void contextLoads() {
	}

	@Test
	public void canFindCustomersOverAge(){
		List<Customer> expected = customerRepository.findCustomerOverAgeByTownAndCourse(21, "glasgow", 1L);
		assertEquals(1, expected.size());
	}

}
