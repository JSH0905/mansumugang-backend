package org.mansumugang.mansumugang_service.domain.community;

import jakarta.persistence.*;
import lombok.*;
import org.mansumugang.mansumugang_service.domain.user.Protector;
import org.mansumugang.mansumugang_service.dto.community.comment.CommentSave;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@Getter
@Table
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@EntityListeners(AuditingEntityListener.class)
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    private String content;

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;

    private LocalDateTime deletedAt;


    // 다른 테이블과의 관계

    // 1. 게시물
    @ManyToOne(fetch = FetchType.LAZY)
    Post post;

    @ManyToOne(fetch = FetchType.LAZY)
    Protector protector;


    public static Comment of(CommentSave.Request request, Post post, Protector protector){
        return Comment.builder()
                .content(request.getContent())
                .post(post)
                .protector(protector)
                .build();
    }
}
