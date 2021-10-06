package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Issue;
import ru.netology.repository.IssueRepository;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class IssueManagerTest {
    private IssueManager manager = new IssueManager();
    private IssueRepository repository = new IssueRepository();

    Issue issue1 = new Issue(1, "Shildt", true, false,
            new HashSet<String>(Arrays.asList("label1", "label2")), new HashSet<String>(Arrays.asList("Volkov", "Kotov")));
    Issue issue2 = new Issue(2, "Bird", true, false,
            new HashSet<String>(Arrays.asList("label1", "label3")), new HashSet<String>(Arrays.asList("Kotov", "Sorokin")));
    Issue issue3 = new Issue(3, "Kornell", false, true,
            new HashSet<String>(Arrays.asList("label3", "label2")), new HashSet<String>(Arrays.asList("Sorokin", "Volkov")));

    @BeforeEach
    public void setUp() {
        manager.add(issue1);
        manager.add(issue2);
        manager.add(issue3);
    }

    @Test
    public void shouldAddIssues() {
        List<Issue> expected = List.of(issue1, issue2, issue3);
        repository.addAll(expected);
        List<Issue> actual = repository.getAll();
        assertEquals(expected, actual);
    }

    @Test
    public void shouldOpenIssues() {
        List<Issue> expected = List.of(issue1, issue2);
        List<Issue> actual = manager.openIssue(true);
        assertEquals(expected, actual);
    }

    @Test
    public void shouldCloseIssues() {
        List<Issue> expected = List.of(issue3);
        List<Issue> actual = manager.closeIssue(true);
        assertEquals(expected, actual);
    }

    @Test
    public void shouldFilterByAuthorIssue() {
        List<Issue> expected = List.of(issue2);
        List<Issue> actual = manager.filterByAuthorIssue("Bird");
        assertEquals(expected, actual);
    }

    @Test
    public void shouldCloseIssueById() {
        List<Issue> expected = List.of(issue3);
        List<Issue> actual = Arrays.asList(manager.closeIssueById(3));
        assertEquals(expected, actual);
    }

    @Test
    public void shouldFilterByLabelIssue() {
        List<Issue> expected = List.of(issue1, issue2);
        List<Issue> actual = manager.filterByLabelIssue("label1");
        assertEquals(expected, actual);
    }

    @Test
    public void shouldFilterByAssigneelIssue() {
        List<Issue> expected = List.of(issue2, issue3);
        List<Issue> actual = manager.filterByAssigneeIssue("Sorokin");
        assertEquals(expected, actual);
    }
}