package presenter;

import model.Calculator;

import view.View;

import java.io.IOException;
import java.lang.System.Logger.Level;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Presenter {
    private Calculator calculator;
    private View view;

    private String results = "";

    public Presenter(Calculator calculator) {
        this.calculator = calculator;

        this.view = new View(calculator);

    }

    public void start() throws SecurityException, IOException {
        boolean flag = true;
        while (flag) {
            view.print("Калькулятор для комплексных чисел: \n" +
                    "1. Совершить операцию\n" +

                    "q. Завершить работу\n");
            switch (view.getChoice()) {
                case "1":
                    // TODO: 1. Совершить операцию
                    String result = operation();
                    results += result + "\n";
                    view.print(result);
                    break;

                case "q":
                    // TODO: 6. Выйти
                    view.print("Калькулятор завершает работу"); // logView
                    flag = false;
                    break;
                default:
                    view.print("!!! Неверный выбор !!!");
                    break;
            }
        }

    }

    private String operation() throws SecurityException, IOException {
        view.print(
                "Введите Первое комплексное число в формате \"x y\",\n где 'х' - вещественная часть, а 'y' - комплексная: ");
        Double[] a = calculator.parse(view.get());
        String result = view.complexToString(a);
        view.print("Введите операнд: '+', '-', '*', '/'");
        char operation = view.getChoice().charAt(0);
        result += " " + operation + " ";
        view.print(
                "Введите Второе комплексное число в формате \"x y\",\n где 'х' - вещественная часть, а 'y' - комплексная: ");
        Double[] b = calculator.parse(view.get());
        result += view.complexToString(b) + " = ";
        Double[] res = calculator.operation(operation, a, b);
        result += view.complexToString(res);
        Logger logger = Logger.getLogger(Presenter.class.getName());

        FileHandler fh = new FileHandler("log.txt");

        logger.addHandler(fh);

        SimpleFormatter sFormat = new SimpleFormatter();

        fh.setFormatter(sFormat);

        logger.info("Result: ");
        return result;
    }
}
