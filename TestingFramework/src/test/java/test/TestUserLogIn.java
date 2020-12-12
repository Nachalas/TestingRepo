package test;

import model.User;
import page.MainPage;
import page.ProfilePage;
import service.UserCreator;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestUserLogIn extends CommonConditions {
    @Test
    public void testCorrectLogIn() {
        User user = UserCreator.withCredentialsFromProperty();
        String expected = user.getUsername();
        new MainPage(driver)
                .openPage()
                .openLogInDialog()
                .logIn(user);
        String actual = new ProfilePage(driver)
                .openPage()
                .getUserEmailFieldText();
        Assert.assertEquals(expected, actual);
    }
}
