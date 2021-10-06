package ru.netology.manager;

import ru.netology.domain.Issue;
import ru.netology.repository.IssueRepository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;


public class IssueManager {
    private IssueRepository repository = new IssueRepository();

    public void add(Issue item) {
        repository.add(item);
    }

    public List<Issue> getAll() {
        return repository.getAll();
    }

    public List<Issue> openIssue(Boolean open) {
        List<Issue> result = new ArrayList<>();
        for (Issue issue : getAll())
            if (open == issue.isOpenIssue()) {
                result.add(issue);
            }
        return result;
    }

    public List<Issue> closeIssue(Boolean close) {
        List<Issue> result = new ArrayList<>();
        for (Issue issue : getAll())
            if (close == issue.isCloseIssue()) {
                result.add(issue);
            }
        return result;
    }

    public List<Issue> filterByAuthorIssue(String author) {
        List<Issue> result = new ArrayList<>();
        for (Issue issue : getAll())
            if (issue.getAuthor().equals(author)) {
                result.add(issue);
            }
        return result;
    }


    public List<Issue> filterByLabelIssue(String label) {
        List<Issue> result = new ArrayList<>();
        for (Issue issue : getAll()) {
            HashSet<String> set = issue.getLabel();
            if (set.contains(label))
                result.add(issue);
        }
        return result;
    }

    public List<Issue> filterByAssigneeIssue(String assignee) {
        List<Issue> result = new ArrayList<>();
        for (Issue issue : getAll()) {
            HashSet<String> set = issue.getAssignee();
            if (set.contains(assignee))
                result.add(issue);
        }
        return result;
    }

    public Issue closeIssueById(int id) {
        Issue result = repository.getById(id);
        boolean closeIssue = result.isCloseIssue();
        result.setCloseIssue(!closeIssue);
        return result;
    }
}
