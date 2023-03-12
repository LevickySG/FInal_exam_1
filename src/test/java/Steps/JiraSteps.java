package Steps;
import Hooks.propertyHooks;
import JiraElements.*;
import io.qameta.allure.Step;
import java.time.Duration;

import static JiraElements.ToolBar.ChooseTopMenuButton;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class JiraSteps extends propertyHooks {
    public static String TaskVersionToCheck;
    public static String TaskStatusToCheck;
    @Step("логин в системе")
    public static void LogInJira() {
        LoginPage.LogWindow.shouldBe(visible, Duration.ofSeconds(5)).setValue(login);
        LoginPage.PassWindow.shouldBe(visible, Duration.ofSeconds(5)).setValue(pass);
        LoginPage.LoginButton.shouldBe(visible, Duration.ofSeconds(5)).click();
    }
    @Step("Переход на страницу задачи")
    public static void TaskStatusAssert(){
        ChooseTopMenuButton("Задачи").shouldBe(visible, Duration.ofSeconds(5)).click();
        Tasks.TaskSearch.shouldBe(visible, Duration.ofSeconds(5)).click();
        Tasks.TextField.setValue(TaskCheckName).pressEnter();
        TaskStatusToCheck = Tasks.TaskStatus();
        TaskVersionToCheck = Tasks.TaskVersions();
        sleep(1000);
    }

    @Step("Создание задачи")
    public static void TaskCreate (){
        Creation.CreateButton.shouldBe(visible,Duration.ofSeconds(5)).click();
        Creation.TaskThemeField.setValue(TaskCreateName);
        Creation.Description.shouldBe(visible, Duration.ofSeconds(5)).setValue(TaskDescription);
        Creation.Environment.shouldBe(visible,Duration.ofSeconds(5)).setValue(TaskEnv);
        Creation.Versions().shouldBe(visible,Duration.ofSeconds(5)).click();
        Creation.CreateConfirm.shouldBe(visible,Duration.ofSeconds(5)).click();
    }

    @Step("Закрытие задачи")
    public static void Close(){//закрытие задачи
        ChooseTopMenuButton("Задачи").shouldBe(visible, Duration.ofSeconds(5)).click();
        Tasks.TaskSearch.shouldBe(visible, Duration.ofSeconds(5)).click();
        Tasks.TextField.setValue(TaskCreateName).pressEnter();
        Tasks.TaskStatusButton.shouldBe(visible, Duration.ofSeconds(20)).click();
        Tasks.SdelatButton.shouldBe(visible, Duration.ofSeconds(20)).click();
        Tasks.BusyButt.shouldBe(visible, Duration.ofSeconds(20)).click();
        Tasks.DoneButt.shouldBe(visible,Duration.ofSeconds(20)).click();
        sleep(1000);
        closeWebDriver();
        //посленяя стрчока выглядит как костыль, но без неё программе не хватает времени, чтобы измениня ушли в Жиру
    }

}
