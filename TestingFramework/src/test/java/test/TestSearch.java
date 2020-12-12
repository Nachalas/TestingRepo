package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.MainPage;
import service.TestDataReader;

public class TestSearch extends CommonConditions {

    private static final String QUERY_PROPERTY = "testdata.query";

    @Test
    public void testPresenceAfterSearch() {
        String expected = TestDataReader.getTestData(QUERY_PROPERTY);
        String actual = new MainPage(driver)
                .openPage()
                .searchForQuery(expected)
                .getFirstItemName();
        Assert.assertTrue(actual.toLowerCase().contains(expected.toLowerCase()));
    }
}
