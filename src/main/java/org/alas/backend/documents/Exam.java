package org.alas.backend.documents;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Document(collection = "Exams")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Exam {

    @Id
    private String id;
    private String examName;
    private int noOfQuestions;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime examStartTime;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime examEndTime;
    private String authorId;
    private List<Object> questionList;

    /*
     * 1st Key -> candidateId
     * 2nd key -> questionId
     * Object -> submission for questionId
     * */
    private Map<String, Map<String, Object>> submissions;
}
