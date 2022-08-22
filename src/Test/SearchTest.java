package Test;
import Lib.CoreTestCase;
import Lib.ui.SearchPageObject;
import io.appium.java_client.AppiumDriver;
import org.junit.Test;

public class SearchTest extends CoreTestCase  {


    @Test
       public void testSearchCancel () {
        SearchPageObject SearchPageObject = new SearchPageObject(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Ka");
        int amount_of_search_results=SearchPageObject.getAmountOfFoundArticles();

        assertTrue(
                "We found few results",
                amount_of_search_results >0
        );
        SearchPageObject.waitCancelButtonToAppear();
        SearchPageObject.clickCancelSearch();
        SearchPageObject.waitCancelButtonToDissappear();

    }



}
