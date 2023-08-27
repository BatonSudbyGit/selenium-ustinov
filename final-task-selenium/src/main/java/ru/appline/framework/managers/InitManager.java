package ru.appline.framework.managers;

import ru.appline.framework.utils.DataWarehousing;

import static org.junit.jupiter.api.Assertions.fail;

public class InitManager {

    private static final DriverManager driverManager = DriverManager.getDriverManager();

    /**
     * Создание общего хранилища данных для всех фреймворков из пакета terminal_to_server
     */
    public static DataWarehousing dw;

    public static void initFramework() {
        driverManager.getDriver().manage().window().maximize();
        dw = new DataWarehousing();
    }

    public static void quitFramework() {
        driverManager.quitDriver();
    }

    public static DataWarehousing getDW() {
        if (dw == null) {
            fail("Объект класса DataWarehousing не создан!");
        }
        return dw;
    }
}
