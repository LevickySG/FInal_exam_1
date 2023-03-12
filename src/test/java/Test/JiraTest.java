package Test;

import JiraElements.propertyHooks;
import io.qameta.allure.Epic;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import Steps.JiraSteps;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Jira tests")
public class JiraTest extends propertyHooks {
    @Epic(value = "Сравнение информации о задаче по имени задачи")
    @Test
    public void  TaskInfo(){
        JiraSteps.LogInJira();
        JiraSteps.TaskStatusAssert();
        Assertions.assertAll(
                ()-> assertEquals(JiraSteps.TaskVersionToCheck,TaskVer,"Сравнение версий"),
                ()-> assertEquals(JiraSteps.TaskStatusToCheck,TaskStatus,"Сравнение статуса")
        );
    }
    @Epic(value = "Создание и закрытие задания в JIRA")
    @Test
    public void TaskCreate(){
        JiraSteps.LogInJira();
        JiraSteps.TaskCreate();
        JiraSteps.Close();
    }
}
