package example.practical.assignment.controllers;

import example.practical.assignment.models.User;
import example.practical.assignment.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import javax.transaction.Transactional;
import java.time.LocalDate;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
@Transactional
class UsersControllerTest {


    @Autowired
    private UserService userService;

    private MockMvc mockMvc;
    UsersControllerTest(MockMvc mockMvc) {
        this.mockMvc = mockMvc;
    }

    @Test
    void searchAll() throws Exception {

        User user = new User();
        user.setName("Jack");
        user.setLastName("Jackson");
        user.setBorn(LocalDate.ofEpochDay(2000 - 07 - 15));
        user.setEmail("umatu@meta.ua");
        user.setAddress("Zhytomir");
        user.setPhone("0631234567");
        User userSave = userService.addUsers(user);

        mockMvc.perform(get("/users/all"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$.[0].name").value("Jack"));
    }
}