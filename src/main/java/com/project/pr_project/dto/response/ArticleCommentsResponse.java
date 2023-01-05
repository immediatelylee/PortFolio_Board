package com.project.pr_project.dto.response;

import com.project.pr_project.dto.ArticleCommentDto;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;


@RequiredArgsConstructor
@EqualsAndHashCode
@Getter
public class ArticleCommentsResponse {
    private final Long id;
    private final String content;
    private final LocalDateTime createdAt;
    private final String email;
    private final String nickname;



    public static ArticleCommentsResponse of(Long id, String content, LocalDateTime createdAt, String email, String nickname) {
        return new ArticleCommentsResponse(id, content, createdAt, email, nickname);
    }

    public static ArticleCommentsResponse from(ArticleCommentDto dto) {
        String nickname = dto.getUserAccountDto().getNickname();
        if (nickname == null || nickname.isBlank()) {
            nickname = dto.getUserAccountDto().getUserId();
        }

        return new ArticleCommentsResponse(
                dto.getId(),
                dto.getContent(),
                dto.getCreatedAt(),
                dto.getUserAccountDto().getEmail(),
                nickname
        );
    }
}
