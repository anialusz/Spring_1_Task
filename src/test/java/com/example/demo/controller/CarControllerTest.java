package com.example.demo.controller;

import com.example.demo.domain.Car;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
class CarControllerTest {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    @Autowired
    MockMvc mockMvc;

    @Test
    void shouldReturn_Ford_Green_GET() throws Exception {
        MvcResult response = mockMvc.perform(
                get("/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();

        Car car = OBJECT_MAPPER.readValue(response.getResponse().getContentAsString(), Car.class);

        assertEquals(new Car(1l, "Ford", "Green"), car);
    }

    @Test
    void shouldReturn4XX_car_POST() throws Exception {
        mockMvc.perform(
                post("/newCar")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andReturn();
    }
}