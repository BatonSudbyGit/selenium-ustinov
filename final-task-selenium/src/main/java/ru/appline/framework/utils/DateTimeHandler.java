package ru.appline.framework.utils;

public class DateTimeHandler {

    /**
     * Метод для ожидания таймаута
     * @param waitSeconds Количество секунд для таймаута.
     */
    public static void waitTimeOutSeconds(int waitSeconds) {
        for (int i = waitSeconds; i > 0; i--) {
            long startTime = System.currentTimeMillis();
            while ((System.currentTimeMillis() - startTime) < 1000) {
            }
        }
    }
}
