package org.alas.backend.dataobjects.exam.question.mcq;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.alas.backend.dataobjects.exam.question.Question;

import java.util.List;


@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MCQQuestion extends Question {
    private List<String> options;
}
