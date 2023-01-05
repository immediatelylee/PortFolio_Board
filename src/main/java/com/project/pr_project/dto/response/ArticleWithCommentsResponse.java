package com.project.pr_project.dto.response;

import com.project.pr_project.dto.ArticleWithCommentsDto;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;


@RequiredArgsConstructor
@EqualsAndHashCode
@Getter
public class ArticleWithCommentsResponse {
    private final Long id;
    private final String title;
    private final String content;
    private final String hashtag;
    private final LocalDateTime createdAt;
    private final String email;
    private final String nickname;
    private final Set<ArticleCommentsResponse> articleCommentsResponse;

    public static ArticleWithCommentsResponse of(Long id, String title, String content, String hashtag, LocalDateTime createdAt, String email, String nickname, Set<ArticleCommentsResponse> articleCommentsResponse) {
        return new ArticleWithCommentsResponse(id, title, content, hashtag, createdAt, email, nickname, articleCommentsResponse);
    }

    public static ArticleWithCommentsResponse from(ArticleWithCommentsDto dto) {
        String nickname = dto.getUserAccountDto().getNickname();
        if (nickname == null || nickname.isBlank()) {
            nickname = dto.getUserAccountDto().getUserId();
        }
        
        return new ArticleWithCommentsResponse(
                dto.getId(),
                dto.getTitle(),
                dto.getContent(),
                dto.getHashtag(),
                dto.getCreatedAt(),
                dto.getUserAccountDto().getEmail(),
                nickname,
                dto.getArticleCommentDtos().stream()
                        .map(ArticleCommentsResponse::from)
                        .collect(Collectors.toCollection(LinkedHashSet::new))
        );
    }


}
