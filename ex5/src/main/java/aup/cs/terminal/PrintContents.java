package aup.cs.terminal;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class PrintContents extends Command  {
    /*ls` - lists the content of the current directory which should contain: 1) the date when it was last modified, 2) its size in bytes, 3) distinguish files from directories
    In addition
     */
    public PrintContents() {
        System.out.println("A print objects object has been created");
    }

    public void print() throws TerminalExecutionException {
        // why is this not working?!?!?
        StringBuilder builder = new StringBuilder();
        try{
            Scanner s = new Scanner(file);
            while(s.hasNextLine()){
                System.out.println("builder is building");
                builder.append(s.nextLine());
            }
            System.out.println(builder.toString());
        }
        catch (FileNotFoundException e) {
            throw new TerminalExecutionException(e.getMessage());
        }
    }
}
