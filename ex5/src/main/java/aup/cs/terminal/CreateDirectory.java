package aup.cs.terminal;

import java.io.File;

public class CreateDirectory extends Command  {
    public CreateDirectory() {
        file.mkdir();
    }
}
