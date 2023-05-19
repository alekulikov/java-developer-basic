package ru.otus.exceptionservice;

import ru.otus.exceptions.MappingException;

import java.io.IOException;
import java.rmi.AccessException;
import java.util.Arrays;
import java.util.Optional;

/**
 * класс с обработками исключений
 */
public class Repository {
    private final String address;
    private final String credential;

    public Repository(String address, String credential) {
        this.address = address;
        this.credential = credential;
    }

    /**
     * пример с выводом ошибки в консоль
     */
    public boolean saveData(byte[] data) {
        String successful = null;
        try (DataSource dataSource = new DataSource(address)) {
            //пытаемся сохранить данные
            successful = dataSource.execute(credential, "save " + Arrays.toString(data));
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return successful != null && successful.equals("success");
    }

    /**
     * возвращаем значение по-умолчанию
     */
    public Optional<Object> findData(String id) {
        Object object = new Object();
        String data = null;
        try (DataSource dataSource = new DataSource(address)) {
            //пытаемся получить объект
            data = dataSource.execute(credential, "find " + id);
            object = map(data);
        } catch (AccessException e) {
            return Optional.empty();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return Optional.of(object);
    }

    /**
     * оборачиваем в свое исключение и делаем rethrow
     */
    private Object map(String data) {
        try {
            // пытаемся смапить
            if (System.currentTimeMillis() % 2 == 0) {
                return data;
            } else {
                //но что-то идет не так
                throw new RuntimeException("Значение не может быть преобразовано");
            }
        } catch (RuntimeException e) {
            throw new MappingException("\"" + data + "\"" + " - " + e.getMessage(), e);
        }
    }

}
