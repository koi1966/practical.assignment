package example.practical.assignment.controllers;

import example.practical.assignment.models.User;
import example.practical.assignment.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.bind.annotation.RequestMapping;

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
    private MockMvc mockMvc;
    @Autowired
    private UserService userService;

    //    private final Mapper mapper = Mappers.getMapper(Mapper.class);


    @Test

    void searchAll() throws Exception {
        User user = new User();
        user.setName("Max");
        user.setLastName("Olsha");
        user.setBorn(LocalDate.ofEpochDay(2000 - 07 - 15));
        user.setEmail("umatu@meta.ua");
        user.setAddress("Zhytomir");
        user.setPhone("0631234567");
        User userSave = userService.addUsers(user);

        mockMvc.perform(get("/users/all"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$.[0].name").value("Max"));
    }

}