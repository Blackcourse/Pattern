package Tests;

import org.junit.Test;
import ui.ArticlePageObject;
import ui.SearchPageObject;

import static org.junit.Assert.assertEquals;

public class ArticleTests extends CoreTestCase {
    @Test
    public void testCompareArticleTitle ()
    {
        SearchPageObject SearchPageObject = new SearchPageObject(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.clickByArticleWithSubstring("Object-oriented programming language");
        ArticlePageObject ArticlePageObject = new ArticlePageObject(driver);
        String article_title=ArticlePageObject.getArticleTitle ();

        assertEquals(
                "We see unexp titile",
                "Java (programming language)",
                article_title
        );
    }

}
