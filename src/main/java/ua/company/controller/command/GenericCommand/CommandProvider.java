package ua.company.controller.command.GenericCommand;

import ua.company.controller.command.impl.*;
import ua.company.model.dao.genericDAO.GenericDAO;
import ua.company.model.dao.impl.UserAutentifDAO;

import java.util.EnumMap;

/**
 * Created by Владислав on 29.09.2017.
 */
public class CommandProvider {
    private EnumMap<CommandEnum, CommandOriginal> commands = new EnumMap<>(CommandEnum.class);

    public CommandProvider() {
        commands.put(CommandEnum.REG_BY_USER, new RegistrationFormExecution(new UserAutentifDAO()));
    }

    public CommandOriginal getCommand(String nameCommand) {
        CommandEnum currentCommand;
        currentCommand = CommandEnum.valueOf(nameCommand);

        return commands.get(currentCommand);
    }

}
