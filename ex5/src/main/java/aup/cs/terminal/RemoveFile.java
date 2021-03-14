package aup.cs.terminal;

public class RemoveFile  extends Command {
    public RemoveFile() {
        try{
            file.delete();
            System.out.println("File will be deleted");
                if(!(file.delete())) {
                    throw new TerminalExecutionException("File could not be deleted");
                }
        }
        catch (TerminalParsingException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
