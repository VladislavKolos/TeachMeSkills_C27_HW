package org.example.model;

import lombok.Builder;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@Getter
@SuperBuilder
public class Task extends AbstractTask {
    @Builder.Default
    private List<SubTask> subTasks = new ArrayList<>();
}
