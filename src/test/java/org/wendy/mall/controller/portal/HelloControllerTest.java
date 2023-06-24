package org.wendy.mall.controller.portal;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.wendy.mall.dto.UmsAdminLoginParam;

import javax.annotation.Resource;

@SpringBootTest
public class HelloControllerTest {
    private static final String AUTHORIZATION = "Authorization";

    private static String token;

    private static MockMvc mockMvc;

    @Resource
    private HelloController helloController;

    @BeforeAll
    public static void initializeToken(WebApplicationContext wac)throws Exception {
        initializeMockMvc(wac);

        UmsAdminLoginParam loginParam = new UmsAdminLoginParam();
        loginParam.setUsername("wendyma");
        loginParam.setPassword("52wendyma");
        ObjectMapper objectMapper = new ObjectMapper();
        String content = objectMapper.writeValueAsString(loginParam);

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/admin/login")
                .content(content)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andReturn();
        String contentAsString = result.getResponse().getContentAsString();
        JsonNode jsonNode = objectMapper.readTree(contentAsString);
        token = jsonNode.get("data").get("token").asText();
    }

    static void initializeMockMvc(WebApplicationContext wac){
        // 方式1：明确指定需要测试的“Controller”类
        // this.mockMvc = MockMvcBuilders.standaloneSetup(helloController).build();

        // 方式2：基于Spring容器进行配置，包含了Spring MVC环境和所有“Controller”类。
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    void test_hello() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/hello/world")
                .header(AUTHORIZATION, token)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andReturn(); // 获取返回结果
        Assertions.assertEquals("Hello World", result.getResponse().getContentAsString());
    }
}
