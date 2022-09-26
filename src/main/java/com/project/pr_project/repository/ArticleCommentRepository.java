package com.project.pr_project.repository;

import com.project.pr_project.domain.Article;
import com.project.pr_project.domain.ArticleComment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleCommentRepository extends JpaRepository<ArticleComment,Long> {
}
