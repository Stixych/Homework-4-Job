import com.codeborne.selenide.Configuration;
import org.testng.annotations.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selectors.byXpath;

public class BtaPortalTests {

    @Test
    public void testBtaPortal() {
        // 1. Atvērt BTA portālu (www.bta.lv)
        Configuration.browser = "chrome";
        open("https://www.bta.lv");

        $(byXpath("/html/body/div[1]/section/div/div[3]/button[3]")).click();

        // 2. Pārvietoties uz ceļojuma polišu iegādes formu
        $(byXpath("/html/body/div[1]/main/section[1]/div/div/div[3]/a[2]")).click();
        // 3. Izvēlēties ceļojuma galamērķi
        $(byXpath("/html/body/div[1]/main/section[2]/div/div/section/div[1]/div/div/div[2]/div/button")).click();

        // 3.1. Izvēlēties "Izvēlies valstis"
        $(byXpath("/html/body/div[1]/main/section[2]/div/div/section/div[1]/div/div/div[2]/div/div/aside/div/span/div/div[2]/div")).click();

        // 3.2. Izvēlēties "Pievienot valsti"
        $(byXpath("/html/body/div[1]/main/section[2]/div/div/section/div[1]/div/div/div[2]/div/div/aside/div/span/div/div[3]/aside/div/div[2]/div/div[2]/button")).click();
        // 3.3. Ievadīt "Indija" un to izvēlēties
        $("[data-value='Indija']").click();

        // 3.4. Nospiest "Pielietot"
        $(byXpath("/html/body/div[1]/main/section[2]/div/div/section/div[1]/div/div/div[2]/div/div/aside/div/span/div/div[3]/aside/div/div[4]/button")).click();

        // 4. Parbaudīt vai tika ieviestas izmaiņas.
        String Parbaude = $(By.xpath("/html/body/div[1]/main/section[2]/div/div/section/div[1]/div/div/div[2]/div/button/span[1]")).getText();

        if (Parbaude.contains("Visa pasaule")) {
            // 5. Nomainīt aktivitāti uz "Sports"
            $(byXpath("/html/body/div[1]/main/section[2]/div/div/section/div[5]/div/div[2]/div/button")).click();
            $(byXpath("/html/body/div[1]/main/section[2]/div/div/section/div[5]/div/div[2]/div/div/aside/div/span/button[4]")).click();

        } else {
            // Darbības beigšana, jo nenostājās nosacījumi.
            return;
        }

        // 6. Parbaudīt vai tika ieviestas aktivitātes izmaiņas
        String Parbaude_2 = $(By.xpath("/html/body/div[1]/main/section[2]/div/div/section/div[5]/div/div[2]/div/button/span[1]")).getText();

        if (Parbaude_2.contains("Sports")) {
            // 7. Pārvietoties uz otro soli
            $(byXpath("/html/body/div[1]/main/section[2]/div/div/section/div[7]/div/button")).click();

        } else {
            // Darbības beigšana, jo nenostājās nosacījumi.
            return;
        }

        // 8. Izvēlēties Optimal+
        $(byXpath("/html/body/div[1]/main/section[2]/div/div/section[3]/section/div[2]/button[1]")).click();

        // 9. Atvērt "Apskati, kas ir apdrošināts" izvēlētajai programmai

        // 9.1. Atgriezties atpakaļ
        $(byXpath("/html/body/div[1]/main/section[1]/div/div/div/div[2]/div[3]")).click();

        // 9.2. Nospiest uz "apskati" pogu
        $(byXpath("/html/body/div[1]/main/section[2]/div/div/section[3]/section/div[2]/button[2]")).click();

        // 10. Pārbaudīt vai uzlecošā forma ir atvērusies
        if ($(By.xpath("/html/body/div[1]/div[1]/aside/div")).isDisplayed()) {
            // 11. Aizvērt un pārvietoties uz nākamo soli
            $(byXpath("/html/body/div[1]/div[1]/aside/div/button")).click();
            $(byXpath("/html/body/div[1]/main/section[1]/div/div/div/div[3]")).click();

        } else {
            // Darbības beigšana, jo nenostājās nosacījumi.
            return;
        }

        // 12. Pārbaudīt vai ceļotāja lauki ir redzami un tie ir tukši
        if      ($(By.xpath("/html/body/div[1]/main/section[2]/div/div/section/div[2]/div[1]/div[3]/div[1]/div[2]/input")).isDisplayed() &&
                $(By.xpath("/html/body/div[1]/main/section[2]/div/div/section/div[2]/div[1]/div[3]/div[1]/div[2]/input")).getValue().isEmpty() &&

                $(By.xpath("/html/body/div[1]/main/section[2]/div/div/section/div[2]/div[1]/div[3]/div[2]/div[2]/input")).isDisplayed() &&
                $(By.xpath("/html/body/div[1]/main/section[2]/div/div/section/div[2]/div[1]/div[3]/div[2]/div[2]/input")).getValue().isEmpty() &&

                $(By.xpath("/html/body/div[1]/main/section[2]/div/div/section/div[2]/div[1]/div[3]/div[3]/div[2]/input")).isDisplayed() &&
                $(By.xpath("/html/body/div[1]/main/section[2]/div/div/section/div[2]/div[1]/div[3]/div[3]/div[2]/input")).getValue().isEmpty()
        ){
            System.out.println("Darbs ir veiksmīgi izpildīts!");
        } else {
            return;
        }
    }
}