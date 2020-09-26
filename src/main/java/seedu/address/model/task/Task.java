package seedu.address.model.task;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Represents a Task of a project.
 * Guarantees: details are present and not null, field values are validated, immutable.
 */
public class Task {
    private final String name;
    private final String description;
    private final LocalDate publishDate;
    private final LocalDateTime deadline;
    private final double progress;
    private final boolean isDone;

    public Task(String name, String description, LocalDateTime deadline, double progress, boolean isDone) {
        this.name = name;
        this.description = description;
        publishDate = LocalDate.now();
        this.deadline = deadline;
        this.progress = progress;
        this.isDone = isDone;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getPublishDate() {
        return publishDate;
    }

    public LocalDateTime getDeadline() {
        return deadline;
    }

    public double getProgress() {
        return progress;
    }

    public boolean isDone() {
        return isDone;
    }

    /**
     * Returns true if all fields are equal.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return Double.compare(task.getProgress(), getProgress()) == 0 &&
                getName().equals(task.getName()) &&
                getDescription().equals(task.getDescription()) &&
                getPublishDate().equals(task.getPublishDate()) &&
                Objects.equals(getDeadline(), task.getDeadline());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getDescription(), getPublishDate(), getDeadline(), getProgress(), isDone());
    }
}
