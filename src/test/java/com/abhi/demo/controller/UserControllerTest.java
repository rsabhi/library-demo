package com.abhi.demo.controller;

import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.abhi.demo.entity.User;
import com.abhi.demo.entity.User.Gender;
import com.abhi.demo.service.UserService;
import java.util.Collections;
import java.util.Set;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = UserController.class, secure = false)
public class UserControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private UserService service;

  @Test
  public void testGetAll() throws Exception {
    User user = new User();
    user.setId(1);
    user.setName("Aaa Bbb");
    user.setAddress("CA");
    user.setGender(Gender.Female);
    user.setPhoneNumber("123456789");
    Set<User> users = Collections.singleton(user);
    when(service.getAll()).thenReturn(users);
    mockMvc.perform(get("/users")).andExpect(status().isOk())
        .andExpect(jsonPath("$[0].id").value(1))
        .andExpect(jsonPath("$[0].name").value("Aaa Bbb")).andExpect(
        jsonPath("$[0].gender").value("Female"))
        .andExpect(jsonPath("$[0].phoneNumber").value("123456789"));
  }

  @Test
  public void testGet() throws Exception {
    User user = new User();
    user.setId(10);
    user.setName("Abc Def");
    user.setAddress("New York");
    user.setGender(Gender.Male);
    user.setPhoneNumber("987654321");
    when(service.get(anyLong())).thenReturn(user);
    mockMvc.perform(get("/users/10")).andExpect(status().isOk())
        .andExpect(jsonPath("$.id").value(10))
        .andExpect(jsonPath("$.name").value("Abc Def")).andExpect(
        jsonPath("$.gender").value("Male"))
        .andExpect(jsonPath("$.phoneNumber").value("987654321"));
  }
}
