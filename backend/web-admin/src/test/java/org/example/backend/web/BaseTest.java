package org.example.backend.web;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import jakarta.annotation.Resource;
import java.io.File;
import java.io.FileInputStream;

/**
 * @Description:
 * @Author: liwu3
 * @Date: 2021/6/11 14:45
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK, classes = AdminApplication.class)
@AutoConfigureMockMvc
public class BaseTest {

    @Resource
    private MockMvc mockMvc;


    @Test
    public void testGetAllSimple() throws Exception {
        String result = mockMvc.perform(MockMvcRequestBuilders
                .get("/common/user/getAllSimple")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
        ).andExpect(MockMvcResultMatchers.status().isOk()).andReturn().getResponse().getContentAsString();
        System.out.println(result);
    }

    @Test
    public void testUploadFile() throws Exception {
        File file = new File("C:\\Users\\yyadmin\\Desktop\\test.png");
        MockMultipartFile mockMultipartFile = new MockMultipartFile("file", "test.png", "multipart/form-data",
                new FileInputStream(file));
        String result = mockMvc.perform(
                        MockMvcRequestBuilders.multipart("/common/uploadFile")
                                .file(mockMultipartFile)
                ).andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn().getResponse().getContentAsString();
        System.out.println(result);
    }

}
