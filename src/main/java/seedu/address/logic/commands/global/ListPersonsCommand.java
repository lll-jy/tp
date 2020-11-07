package seedu.address.logic.commands.global;

import static java.util.Objects.requireNonNull;
import static seedu.address.model.Model.PREDICATE_SHOW_ALL_PERSONS;

import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.CommandResult;
import seedu.address.model.Model;

/**
 * Lists all persons in the main catalogue to the user.
 */
public class ListPersonsCommand extends Command {

    public static final String COMMAND_WORD = "listpersons";

    public static final String MESSAGE_EXTRA_ARGS = "Please do not provide extra arguments after \""
        + COMMAND_WORD + "\"";
    public static final String MESSAGE_SUCCESS = "Listed all persons";


    @Override
    public CommandResult execute(Model model) {
        requireNonNull(model);
        model.updateFilteredPersonList(PREDICATE_SHOW_ALL_PERSONS);
        model.setAsPersonList();
        return new CommandResult(MESSAGE_SUCCESS);
    }
}
