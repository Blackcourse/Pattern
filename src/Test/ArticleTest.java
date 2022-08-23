package Test;
import Lib.CoreTestCase;
import Lib.ui.ArticlePageObject;
import Lib.ui.MyListPageObject;
import Lib.ui.NavigationUI;
import Lib.ui.SearchPageObject;
import io.appium.java_client.AppiumDriver;
import org.junit.Test;

public class ArticleTest extends CoreTestCase {
    @Test
    public void testTwoArticles (){
        SearchPageObject SearchPageObject = new SearchPageObject(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.clickByArticleWithSubstring("Object-oriented programming language");
        ArticlePageObject ArticlePageObject = new ArticlePageObject(driver);
        String article_title = ArticlePageObject.getArticleTitle();
        String name_of_folder = "Learning programming";
        ArticlePageObject.addArticleToMyList(name_of_folder);
        ArticlePageObject.closeArticle();
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Kotlin");
        SearchPageObject.clickByArticleWithSubstring("Programming language");
        ArticlePageObject.clickonMyList();
        ArticlePageObject.closeArticle();
        NavigationUI NavigationUI = new NavigationUI(driver);
        NavigationUI.clickMyList();
        MyListPageObject MyListPageObject = new MyListPageObject(driver);
        MyListPageObject.openFolderByName(name_of_folder);
        MyListPageObject.swipeByArticleToDelete(article_title);
        MyListPageObject.waitForArtToAppearAfterDelete();
        MyListPageObject.clickOnSavedPage();


    }


}
