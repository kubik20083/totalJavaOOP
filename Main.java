import model.Calculator;
import presenter.Presenter;
import view.View;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.System.Logger.Level;
import java.util.logging.*;

public class Main {
    public static void main(String[] args) throws SecurityException, IOException {

        Logger logger = Logger.getLogger(Main.class.getName());

        FileHandler fh = new FileHandler("log.txt");

        logger.addHandler(fh);
        
        SimpleFormatter sFormat = new SimpleFormatter();

        fh.setFormatter(sFormat);

        logger.info("Start calculator");

        Presenter presenter = new Presenter(new Calculator());
        presenter.start();
    }
}
