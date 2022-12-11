package com.project.pr_project.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Objects;

@Getter
@ToString(callSuper = true)
@Table(indexes = {
        @Index(columnList ="content"),
        @Index(columnList ="createdAt"),
        @Index(columnList ="createdBy")
})

@Entity
public class ArticleComment extends AuditingFields {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter @ManyToOne(optional = false) private Article article;
    // 게시글 (ID) ManyToOne : 상관관계, optional = false : 해당 필드가 필수로 있어야 함 (casecading = none이 기본)
    @Setter @ManyToOne(optional = false) private UserAccount userAccount; // 유저 정보 (ID)
    @Setter @Column(nullable = false, length = 500) private String content; // 본문


    protected ArticleComment() {}
    /* public ArticleComment(Article article, String content) {
        this.article = article;
        this.content = content;
    } // @NoArgsConstructor로 대체 가능 */

    public ArticleComment(Article article, UserAccount userAccount, String content) {
        this.article = article;
        this.userAccount = userAccount;
        this.content = content;
    } // @NoArgsConstructor로 대체 가능

    /* public static ArticleComment of(Article article, String content) {
        return new ArticleComment(article, content);
    }*/
    public static ArticleComment of(Article article, UserAccount userAccount, String content) {
        return new ArticleComment(article, userAccount, content);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ArticleComment)) return false;
        ArticleComment that = (ArticleComment) o;
        return id != null && id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
