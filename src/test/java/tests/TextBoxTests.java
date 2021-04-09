package tests;


import com.codeborne.selenide.Configuration;
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
        $x("//div[@class='main-header']").shouldHave(text("Text Box"));

        $x("//input[@id='userName']").setValue(name);
        $x("//input[@id='userEmail']").setValue("Viktor@vik.ru");
        $x("//textarea[@id='currentAddress']").setValue("Cur adress here");
        $x("//textarea[@id='permanentAddress']").setValue("Perm adress here");
        $x("//button[@id='submit']").click();

        //sleep(5000);

        $x("//div[@id='output']").shouldHave(text(name), text("Viktor@vik.ru"));

    }
}
