package seedu.address.ui;

import java.util.Optional;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import seedu.address.model.person.Person;

/**
 * An UI component that displays information of a {@code Project}.
 */
public class TeammateDashboard extends UiPart<Region> {

    private static final String FXML = "TeammateDashboard.fxml";

    /**
     * Note: Certain keywords such as "location" and "resources" are reserved keywords in JavaFX.
     * As a consequence, UI elements' variable names cannot be set to such keywords
     * or an exception will be thrown by JavaFX during runtime.
     *
     * @see <a href="https://github.com/se-edu/addressbook-level4/issues/336">The issue on MainCatalogue level 4</a>
     */

    public final Person teammate;

    @FXML
    private HBox teammateDashboardPane;
    @FXML
    private Label teammateName;
    @FXML
    private Label gitUserName;
    @FXML
    private Label phone;
    @FXML
    private Label email;
    @FXML
    private Label address;
    @FXML
    private Label header1;
    @FXML
    private FlowPane projects;

    /**
     * Creates a {@code TaskDashboardCode} with the given {@code Task} to display.
     */
    public TeammateDashboard(Optional<Person> teammate) {
        super(FXML);
        this.teammate = teammate.get();
        teammateName.setText(this.teammate.getPersonName().toString());
        gitUserName.setText("Teammate gitUserName: " + this.teammate.getGitUserNameString());
        phone.setText("Teammate phone number: " + this.teammate.getPhone());
        email.setText("Teammate email: " + this.teammate.getEmail());
        address.setText("Teammate address: " + this.teammate.getAddress());
        header1.setText("Projects participated: ");
        this.teammate.getParticipations().keySet()
                .forEach(participation -> projects.getChildren()
                        .add(new Label(participation.toString())));
    }

    @Override
    public boolean equals(Object other) {
        // short circuit if same object
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof TeammateDashboard)) {
            return false;
        }

        // state check
        TeammateDashboard card = (TeammateDashboard) other;
        return teammate.equals(card.teammate);
    }
}