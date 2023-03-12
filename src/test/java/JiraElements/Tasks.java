package JiraElements;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.*;
import org.openqa.selenium.By;

public class Tasks extends propertyHooks{
    public static SelenideElement TaskSearch = $x("//a[contains(text(), 'Поиск задач')]");
    public static SelenideElement BusyButt = $x("//span[contains(text(),'Бизнес-процесс')]//parent::a");
    public static SelenideElement DoneButt = $x("//span[contains(text(),'Выполнено')]");
    public static SelenideElement TaskStatusButton = $x("//div[@data-id='status']");
    public static SelenideElement SdelatButton = $x("//label[@data-descriptor-title='Сделать']");
    public static SelenideElement TextField = $x("//input[@placeholder=\"Содержит текст\"]");

    public static String TaskStatus(){
        return ($(By.xpath("//span[@id='status-val']//child::span")).getText());
    }
    public static String TaskVersions(){
        return $(By.xpath("//strong[@title='Исправить в версиях']" +
                "//following-sibling::span//child::span//child::a")).getText();
    }
}
