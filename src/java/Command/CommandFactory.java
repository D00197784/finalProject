/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Command;

/**
 *
 * @author D00194667
 */
public class CommandFactory {

    private volatile static CommandFactory currentInstance;

    private CommandFactory() {

    }

    public static CommandFactory getInstance() {

        if (currentInstance == null) {
            synchronized (CommandFactory.class) {
                if (currentInstance == null) {
                    currentInstance = new CommandFactory();
                }
            }
        }
        return currentInstance;
    }

    public static Command createCommand(String action) {
        Command command = null;

        if (action != null) {
//           
            switch (action) {
                case "login":
                    command = new LoginUserCommand();
                    break;

                case "register":
                    command = new RegisterUserCommand();
                    break;

                case "logout":
                    command = new LogoutCommand();
                    break;

                case "changeLanguage":
                    command = new ChangeLanguageCommand();
                    break;

            }
        } else {
            command = new NoActionSuppliedCommand();
        }
        return command;

    }
}
