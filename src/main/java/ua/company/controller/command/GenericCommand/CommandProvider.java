package ua.company.controller.command.GenericCommand;

import ua.company.controller.command.impl.*;

import java.util.EnumMap;

/**
 * Created by Владислав on 29.09.2017.
 */
public class CommandProvider {
    private EnumMap<CommandEnum, CommandOriginal> commands = new EnumMap<>(CommandEnum.class);

    public CommandProvider() {
        commands.put(CommandEnum.REG_BY_USER, new RegistrationByUser());
        commands.put(CommandEnum.FORM_BY_USER,new ExecutionFormByUser());
        commands.put(CommandEnum.ADD_USER_TO_SHEET,new AddingUserToSheet());
        commands.put(CommandEnum.START_BL,new StartBL());
        commands.put(CommandEnum.SEND_MASSAGES,new MailServlet());
        commands.put(CommandEnum.ADMINS_SIGN_UP,new AdminAutorisation());
    }

    public CommandOriginal getCommand(String nameCommand) {
        CommandEnum currentCommand;
        currentCommand = CommandEnum.valueOf(nameCommand);

        return commands.get(currentCommand);
    }

}
