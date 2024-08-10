package com.beyond.teenkiri.qna.dto;

import com.beyond.teenkiri.qna.domain.QnA;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class QnADetailDto {
    private Long id;
    private String title;
    private String questionText;
    private String answerText;
    private String questionUserNickname;
    private String answeredByNickname;
    private LocalDateTime createdTime;
    private LocalDateTime updatedTime;
    private LocalDateTime answeredAt;
    private String userEmail;
    private String qImageUrl;
    private String aImageUrl;
    public static QnADetailDto fromEntity(QnA qna) {
        return QnADetailDto.builder()
                .id(qna.getId())
                .title(qna.getTitle())
                .questionText(qna.getQuestionText())
                .answerText(qna.getAnswerText())
                .questionUserNickname(qna.getUser().getNickname())
                .answeredByNickname(qna.getAnswerer() != null ? qna.getAnswerer().getNickname() : null)
                .createdTime(qna.getCreatedTime())
                .updatedTime(qna.getUpdatedTime())
                .answeredAt(qna.getAnsweredAt())
                .userEmail(qna.getUser().getEmail())
                .qImageUrl(qna.getQImageUrl())
                .aImageUrl(qna.getAImageUrl())
                .build();
    }
}