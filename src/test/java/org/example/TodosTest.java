package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TodosTest {

    @Test
    public void shouldMatchSimpleTaskByTitle() {
        SimpleTask task = new SimpleTask(1, "Позвонить родителям");

        assertTrue(task.matches("родителям"));
        assertFalse(task.matches("молоко"));
    }

    @Test
    public void shouldMatchEpicBySubtask() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(2, subtasks);

        assertTrue(epic.matches("Яйца"));
        assertFalse(epic.matches("Мясо"));
    }

    @Test
    public void shouldMatchMeetingByTopicOrProject() {
        Meeting meeting = new Meeting(
                3,
                "Выкатка приложения",
                "НетоБанк",
                "Во вторник"
        );

        assertTrue(meeting.matches("Выкатка"));
        assertTrue(meeting.matches("НетоБанк"));
        assertFalse(meeting.matches("Молоко"));
    }
}
