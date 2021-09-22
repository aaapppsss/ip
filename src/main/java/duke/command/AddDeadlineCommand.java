package duke.command;

import duke.Storage;
import duke.TaskList;
import duke.Ui;

import java.time.LocalDate;

public class AddDeadlineCommand extends AddTaskCommand{
    private String description;
    private LocalDate by;
    private String input;

    public AddDeadlineCommand(String description, LocalDate by, String input) {
        this.description = description;
        this.by = by;
        this.input = input;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        tasks.addDeadline(description, by);
        ui.printAddTaskMessage(tasks);
        storage.storeTask(input);
    }

    @Override
    public void addTask(TaskList tasks) {
        tasks.addDeadline(description, by);
    };
}
