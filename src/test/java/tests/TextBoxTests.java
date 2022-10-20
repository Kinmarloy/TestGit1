package tests;


import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class TextBoxTests {

    @BeforeAll
    static void setup(){
        Configuration.startMaximized=true;
    }

    @Test
    void dataAppearsInOutputBlockTests(){
        String  name = "Viktor";

        open("https://demoqa.com/text-box");
        // можно создать xpath элемент заранее и потом использовать просто название элемента,
        // через запятую любое количество можно обозначить
        SelenideElement mainHeader = $x("//div[@class='main-header']"),
                        userName = $x("//input[@id='userName']");

        mainHeader.shouldHave(text("Text Box"));

        userName.setValue(name); // тоже использовали объявленное имя xpath элемента

        //можно для элементов id использовать css селектор через #
        // а для элементов class через . (точку)
        $("#userEmail").setValue("Viktor@vik.ru");
        $x("//input[@id='userEmail']").setValue("Viktor@vik.ru");

        $x("//textarea[@id='currentAddress']").setValue("Cur adress here");
        $x("//textarea[@id='permanentAddress']").setValue("Perm adress here");
        $x("//button[@id='submit']").click();

        //sleep(5000);

        $x("//div[@id='output']").shouldHave(text(name), text("Viktor@vik.ru"));

    }
}
