package com.xl.devops.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.xl.devops.MainApplication;
import com.xl.devops.com.xl.devops.datasource.ApplicationConfig;
import com.xl.devops.domain.Student;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = MainApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= ApplicationConfig.class)
@ActiveProfiles("test")
public class StudentControllerWebIntegrationTest {
    @Value("${local.server.port}")
    private int port;

    @Test
    @Rollback
    public void shouldCreateStudentAndReturnHttp201Created() {
        System.out.format("port number: %d \n", port);
        Student student = new Student(2l, "Joe", "Doe");

        RestTemplate rest = new RestTemplate();
        ResponseEntity<Student> result = rest.postForEntity("http://localhost:" + port + "/api/students",
                student, Student.class);
        assertThat(result.getStatusCode().toString(), is(HttpStatus.CREATED.toString()));
    }

//    @Test
//    public void shouldGetAllStudentsInDbWhichIs3(){
//        RestTemplate rest = new RestTemplate();
//        ResponseEntity<List<Student>> result = rest.exchange("http://localhost:" + port + "/api/students",
//                HttpMethod.GET, null, new ParameterizedTypeReference<List<Student>>(){});
//        assertThat("the number of data in db", result.getBody().size(), is(3));
//
//    }

//    @Test
//    public void shouldGetAllStudentsInDbWhichIs3SecondTest(){
//        RestTemplate rest = new RestTemplate();
//        ResponseEntity<Student[]> result = rest.getForEntity("http://localhost:" + port + "/api/students",
//                Student[].class);
//        assertThat("the number of data in db", result.getBody().length, is(3));
//
//    }
}
