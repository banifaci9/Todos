package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TasksTest {

    @Test
    public void shouldAddThreeTasksOfDifferentType() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка приложения",
                "НетоБанк",
                "Во вторник"
        );

        Todos todos = new Todos();
        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindOneSuitableTask() {
        SimpleTask simpleTask = new SimpleTask(1, "Позвонить родителям");
        Epic epic = new Epic(2, new String[]{"Купить молоко"});
        Meeting meeting = new Meeting(3, "Встреча", "НетоБанк", "Завтра");

        Todos todos = new Todos();
        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask};
        Task[] actual = todos.search("родителям");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindSeveralSuitableTasks() {
        SimpleTask simpleTask = new SimpleTask(1, "Купить продукты");
        Epic epic = new Epic(2, new String[]{"Купить молоко"});
        Meeting meeting = new Meeting(3, "Купить билеты", "Путешествие", "Завтра");

        Todos todos = new Todos();
        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.search("Купить");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindNoSuitableTasks() {
        Todos todos = new Todos();
        todos.add(new SimpleTask(1, "Позвонить родителям"));

        Task[] expected = {};
        Task[] actual = todos.search("молоко");

        Assertions.assertArrayEquals(expected, actual);
    }
}