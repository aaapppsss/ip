package duke;

import duke.exception.DukeException;
import duke.task.Deadline;
import duke.task.Event;
import duke.task.Task;
import duke.task.Todo;

import java.io.IOException;
import java.util.ArrayList;

public class TaskList {
    private ArrayList<Task> tasks = new ArrayList<>();
    private Ui ui = new Ui();

    public TaskList() {
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }

    public void listTasks() {
        if (tasks.size() > 0) {
            ui.println("Patchi: Here is the list of tasks you currently have! Work hard~ Œ(˙O˙)B");
            for (int i = 0; i < tasks.size(); i++) {
                ui.println((i + 1) + ". " + tasks.get(i).toString());
            }
        } else {
            ui.println("Patchi: You have no tasks for now! Go and relax~ Œ(ˊuˋ)B");
        }
    }

    public void listTasksFromSearch(ArrayList<Task> matchingTasks) {
        if (matchingTasks.size() > 0) {
            ui.println("Patchi: Here is the list of tasks that match your search! Did you find what you were looking for? Œ(˙O˙)B");
            for (int i = 0; i < matchingTasks.size(); i++) {
                ui.println((i + 1) + ". " + matchingTasks.get(i).toString());
            }
        } else {
            ui.println("Patchi: You have no tasks that match that search term! Sorry~ Œ(ˊoˋ)B");
        }
    }

    public void addTodo(String description) {
        tasks.add(new Todo(description));
    }

    public void addDeadline(String description, String by){
        tasks.add(new Deadline(description, by));
    }

    public void addEvent(String description, String at) {
        tasks.add(new Event(description, at));
    }

    public void markTaskAsDone(int taskIndex) throws DukeException {
        if (tasks.size() > taskIndex) {
            tasks.get(taskIndex).setDone(true);
        }  else {
            throw new DukeException("task doesn't exist");
        }
    }

    public void deleteTask(int taskIndex) throws DukeException {
        if (tasks.size() > taskIndex) {
            tasks.remove(taskIndex);
        } else {
            throw new DukeException("task doesn't exist");
        }
    }

    public void findTasks(String searchTerm) throws DukeException {
        ArrayList<Task> matchingTasks = new ArrayList<>();

        for(Task task : tasks) {
            if(task.getDescription().indexOf(searchTerm) != -1) {
                matchingTasks.add(task);
            }
        }

        listTasksFromSearch(matchingTasks);
    }
}
