package ru.otus.exceptionservice;

import java.io.Closeable;
import java.io.IOException;
import java.net.ConnectException;
import java.rmi.AccessException;

/**
 * класс-заглушка для генерации исключений
 */
public class DataSource implements Closeable {

    public DataSource(String address) throws ConnectException {
        if (System.currentTimeMillis() % 4 == 0) {
            throw new ConnectException("Не смогли достучаться до ресурса");
        }
    }
    @Override
    public void close() throws IOException {
        if (System.currentTimeMillis() % 2 != 0) {
            throw new IOException("Сломалось освобождение ресурса");
        }
    }

    public String execute(String credential, String command) throws AccessException {
        if (System.currentTimeMillis() % 2 == 0) {
            throw new AccessException("Пароль не подходит");
        }
        /*
        *что-то происходит с командой
         */
        return "Какая-то информация в ответе";
    }
}
