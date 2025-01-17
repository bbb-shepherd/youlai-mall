package com.youlai.auth.authentication;


import com.youlai.auth.authentication.captcha.CaptchaParameterNames;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.security.oauth2.core.endpoint.OAuth2ParameterNames;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@Slf4j
public class CaptchaAuthenticationTests {

    @Autowired
    private MockMvc mvc;


    @Test
    void testPasswordAuthentication() throws Exception {
        HttpHeaders headers = new HttpHeaders();
        headers.setBasicAuth("mall-admin", "123456");

        // @formatter:off
        this.mvc.perform(post("/oauth2/token")
                        .param(OAuth2ParameterNames.GRANT_TYPE, "captcha")
                        .param(OAuth2ParameterNames.USERNAME, "admin")
                        .param(OAuth2ParameterNames.PASSWORD, "123456")
                        .param(CaptchaParameterNames.VERIFY_CODE, "123456")
                        .param(CaptchaParameterNames.VERIFY_CODE_KEY, "123456")
                        .headers(headers))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.access_token").isNotEmpty());
        // @formatter:on
    }


}