package aup.cs.terminal;

import java.io.File;
import java.io.FileNotFoundException;

public class Command extends Terminal{
    private static String[] possibleCommands = {"exit", "cd", "rm", "cat", "mkdir", "ls'"};
    static protected File file = null;
    static protected String command = "";

    public Command(){}

    public Command(String cmd) throws TerminalParsingException {
        System.out.println("A command object has been created");
        try {
            String[] parsed = parseCmd(cmd);
            String command = parsed[0];
            testList(command);
            if (parsed.length == 2) {
                File file = new File(parsed[1]);
                if(!(file.exists()) && !(command.equals("mkdir"))) {
                    throw new TerminalFlagParsingException();
                }
            }
            Command.execute();
        }
        catch (TerminalParsingException ex){
            System.out.println(ex.getMessage());
        }
    }
    private static void execute() throws TerminalParsingException {
        if(command.equals("rm")) {
            RemoveFile rm = new RemoveFile();
        }
        if(command.equals("cat")) {
            PrintContents p = new PrintContents();
            p.print();
        }
        if(command.equals("mkdir")) {
            CreateDirectory mk = new CreateDirectory();
        }
    }

    private static void testList(String command) throws TerminalCommandParsingException{
        boolean inList = false;
        for (int i = 0; i < possibleCommands.length; i++) {
            if (command.equals(possibleCommands[i])) {
                inList = true;
            }
        }
        if (!inList) {
            throw new TerminalCommandParsingException();
        }
    }

    private static String[] parseCmd(String cmd) throws TerminalArgumentParsingException {
        String[] split = cmd.split(" ");
        if (split.length > 2) {
            throw new TerminalArgumentParsingException();
        }
        return split;
    }

    /* exit - which terminates the program
    cd <d> - changes to another directory
    rm <f> - removes a file from the current directory
    cat <f> - prints the content of the file
    mkdir <d> - creates a new directory with name d
    ls` - lists the content of the current directory which should contain: 1) the date when it was last modified, 2) its size in bytes, 3) distinguish files from directories
    In addition
     */
}
