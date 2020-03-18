package seedu.volant.itinerary.logic.parser;

import static seedu.volant.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.volant.commons.core.Messages.MESSAGE_UNKNOWN_COMMAND;
import static seedu.volant.commons.logic.parser.Parser.BASIC_COMMAND_FORMAT;

import java.util.regex.Matcher;

import seedu.volant.commons.logic.commands.BackCommand;
import seedu.volant.commons.logic.commands.Command;
import seedu.volant.commons.logic.commands.HelpCommand;
import seedu.volant.commons.logic.parser.exceptions.ParseException;
import seedu.volant.itinerary.logic.commands.DeleteCommand;
import seedu.volant.itinerary.model.ActivityList;

/**
 * Parses user input when user is in the ITINERARY page.
 */
public class ItineraryInputParser {

    private ActivityList activityList;

    /**
     * Constructs an ItineraryInputParser to parse commands to be executed on activityList.
     */
    public ItineraryInputParser(ActivityList activityList) {
        this.activityList = activityList;
    }

    public ActivityList getActivityList() {
        return activityList;
    }


    /**
     * Parses user input into command for execution.
     *
     * @param userInput full user input string
     * @return the command based on the user input
     * @throws ParseException if the user input does not conform the expected format
     */
    public Command parseCommand(String userInput) throws ParseException {
        final Matcher matcher = BASIC_COMMAND_FORMAT.matcher(userInput.trim());
        if (!matcher.matches()) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, HelpCommand.MESSAGE_USAGE));
        }
        final String commandWord = matcher.group("commandWord");
        final String arguments = matcher.group("arguments");

        switch(commandWord) {

        case BackCommand.COMMAND_WORD:
            return new BackCommand();

        case DeleteCommand.COMMAND_WORD:
            return new DeleteCommandParser().parse(arguments);

        default:
            throw new ParseException(MESSAGE_UNKNOWN_COMMAND);

        }
    }

}
