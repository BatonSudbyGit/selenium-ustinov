package ru.appline.framework.steps;

import io.cucumber.java.ru.Когда;
import ru.appline.framework.utils.DateTimeHandler;

public class BasePageSteps {

    @Когда("Ожидаем таймаут {int} секунд")
    public void wainTimeOutOfSeconds(int seconds) {
        DateTimeHandler.waitTimeOutSeconds(seconds);
    }
}
