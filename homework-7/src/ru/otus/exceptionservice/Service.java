package ru.otus.exceptionservice;

/**
 * класс для запуска примеров
 */
public class Service {
    public static void main(String[] args) {
        Repository repository = new Repository("address", "superAdmin:password");
        repository.saveData(new byte[] {21, 14, 14, 54});
        repository.findData("777");
    }
}
