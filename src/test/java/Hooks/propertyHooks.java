package Hooks;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeEach;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class propertyHooks {
    public static Properties jiraprop = new Properties();
    public static String login;
    public static String pass;
    public static String TaskCheckName;
    public static String TaskCreateName;
    public static String TaskDescription;
    public static String TaskEnv;
    public static String TaskVer;
    public static String ProjName;
    public static String TaskStatus;
    @BeforeEach
    public void allureStarter(){
        String listenerName = "AllureSelenide";
        if(!(SelenideLogger.hasListener(listenerName)))
            SelenideLogger.addListener(listenerName,
                    new AllureSelenide().screenshots(true).savePageSource(false));
        Selenide.open("https://edujira.ifellow.ru/");
    }

    @BeforeEach
    public void setJiraprop() throws IOException {
        String dir = System.getProperty("user.dir");
        jiraprop.load(new FileInputStream(dir + "/src/test/resources/taskcreate.properties"));
        login =jiraprop.getProperty("login");
        pass=jiraprop.getProperty("pass");
        TaskCheckName=jiraprop.getProperty("TaskCheckName");
        TaskCreateName=jiraprop.getProperty("TaskCreateName");
        TaskDescription=jiraprop.getProperty("TaskDescription");
        TaskEnv=jiraprop.getProperty("TaskEnv");
        TaskVer=jiraprop.getProperty("TaskVer");
        ProjName=jiraprop.getProperty("ProjName");
        TaskStatus=jiraprop.getProperty("TaskStatus");
    }

}
