package aup.cs.terminal;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Terminal {
    static protected boolean running = true;

    public static void main(String[] args) throws TerminalParsingException, IOException {
        File f = new File("whynot");
        f.createNewFile();
        Scanner sc = new Scanner(System.in);
        System.out.println("TESTS: \nTESTING TOO MANY ARGUMENTS: ");
        Command cmdTooMany = new Command("exit file too many");
        System.out.println("TESTING INVALID COMMAND: ");
        Command invalidCommand = new Command("run file");
        System.out.println("TESTING INVALID FLAG: ");
        Command invalidFlag = new Command("cd noFile");
        System.out.println("\n \n \nSTART OF TERMINAL:");
        makeTestFile();
        while (running) {
            System.out.println("Possible Commands Include: \"cd <d>\", \"rm <f>\", \"cat <f>\", \"mkdir <d>\", \"ls`\", \"exit\"");
            System.out.println(getCurrent() + " >");
            String command = sc.nextLine();
            if(command.equals("exit")) {
                running = false;
            }
            Command cmd = new Command(command);
            System.out.println(f.exists());
        }
        System.out.println("Terminal has been closed");
    }

    private static String getCurrent(){
        try{
            String current = new java.io.File( "." ).getCanonicalPath();
            return current;
        }
        catch (java.io.IOException ioExc){
            System.out.print(ioExc.getMessage());
        }
        return "";
    }

    private static File makeTestFile() {
        // Not Working!!!
        File f = new File("Test");
        try {
            PrintWriter printer = new PrintWriter(f);
            printer.println("Hello \nWorld\nThis\nIs a test\nFile to see");
            printer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        finally {
            return f;
        }
    }
}