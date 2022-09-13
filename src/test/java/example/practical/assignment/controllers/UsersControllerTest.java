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

    @Test
    void editUser() throws Exception {
        User user = new User();
        user.setName("Jack");
        user.setLastName("Jackson");
        user.setBorn(LocalDate.ofEpochDay(2000 - 07 - 15));
        user.setEmail("umatu@meta.ua");
        user.setAddress("Zhytomir");
        user.setPhone("0631234567");
        User userSave = userService.addUsers(user);

        final UserDto userDto = new UserDto();
        userDto.setEmail("newEmail@mail.com");
        userDto.setName("NEW");
        userDto.setLastName("JacksonNew");

        String json = "{\"email\" : \"newEmail@mail.com\", \"name\" : \"NEW\", \"lastName\" : \"JacksonNew\", \"born\" : \"2002-07-15\"}";

        mockMvc.perform(put("/users/?id=" + userSave.getId()).content(json)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
        final User savedUser = userRepository.findById(userSave.getId()).get();
        Assertions.assertEquals(userDto.getEmail(), savedUser.getEmail());
        Assertions.assertEquals(userDto.getName(), savedUser.getName());
        Assertions.assertEquals(userDto.getLastName(), savedUser.getLastName());
        Assertions.assertEquals("2002-07-15", savedUser.getBorn().toString());
    }

}