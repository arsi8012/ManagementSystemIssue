package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Issue {
    private int id;
    private String author;
    private boolean openIssue;
    private boolean closeIssue;
    private HashSet<String> label;
    private HashSet<String> assignee;
}
