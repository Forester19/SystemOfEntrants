package ua.company.epam.controller.command;

import ua.company.epam.controller.command.impl.AdminSignUpCommandOriginal;
import ua.company.epam.controller.command.impl.RegistrationByUser;

import java.util.EnumMap;

/**
 * Created by Владислав on 29.09.2017.
 */
public class CommandProvider {
    private EnumMap<CommandEnum, CommandOriginal> commands = new EnumMap<CommandEnum, CommandOriginal>(CommandEnum.class);

    public CommandProvider() {
        commands.put(CommandEnum.ADMINS_SIGN_IN, new AdminSignUpCommandOriginal());
        commands.put(CommandEnum.REG_BY_USER, new RegistrationByUser());
    }

    public CommandOriginal getCommand(String nameCommand) {
        CommandEnum currentCommand;
        currentCommand = CommandEnum.valueOf(nameCommand);

        return commands.get(currentCommand);
    }

}
