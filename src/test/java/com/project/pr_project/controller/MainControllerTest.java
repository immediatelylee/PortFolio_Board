package com.project.pr_project.controller;

import com.project.pr_project.config.SecurityConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@DisplayName("view 컨트롤러 - 리다이렉션")
@Import(SecurityConfig.class)
@WebMvcTest(MainController.class)
class MainControllerTest {

    private final MockMvc mvc;


    public MainControllerTest(@Autowired MockMvc mvc) {

        this.mvc = mvc;
    }

    @DisplayName("[VIEW][GET] 루트 페이지 -> 게시판 페이지로 포워딩")
    @Test
    void givenNothing_whenRequestingRootPage_thenRedirectsToArticle() throws Exception{
        // Given

        // When
        mvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("forward:/article"))
                .andExpect(forwardedUrl("/articles"))
                .andDo(MockMvcResultHandlers.print());
        // Then

    }

}