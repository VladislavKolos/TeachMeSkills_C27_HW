package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@SuperBuilder
public class Task extends AbstractTask {
    @Builder.Default
    private List<SubTask> subTasks = new ArrayList<>();
}
