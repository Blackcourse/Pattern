import org.junit.Test;
import ui.*;


public class FirstTest extends CoreTestCase {

    @Test
    public void testSearch () {
        SearchPageObject SearchPageObject = new SearchPageObject(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.waitForSearchResult("Object-oriented programming language");
    }
    @Test
    public void testCancelSearch ()
    {
        SearchPageObject SearchPageObject = new SearchPageObject(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.waitCancelButtonToAppear();
        SearchPageObject.clickCancelSearch();

    }
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
    @Test
    public void testSwipeArticle () {
        SearchPageObject SearchPageObject = new SearchPageObject(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Appium");
        SearchPageObject.clickByArticleWithSubstring("Appium");
        ArticlePageObject ArticlePageObject = new ArticlePageObject(driver);
        ArticlePageObject.waitForTitleElement();
        ArticlePageObject.swipeTofooter();
    }

        @Test
    public void testFirstToMylist() {
            SearchPageObject SearchPageObject = new SearchPageObject(driver);
            SearchPageObject.initSearchInput();
            SearchPageObject.typeSearchLine("Java");
            SearchPageObject.clickByArticleWithSubstring("Object-oriented programming language");
            ArticlePageObject ArticlePageObject = new ArticlePageObject(driver);
            ArticlePageObject.waitForTitleElement();
            String article_title = ArticlePageObject.getArticleTitle();
            String name_of_folder = "Learning programming";
            ArticlePageObject.addArticleToMyList(name_of_folder);
            ArticlePageObject.closeArticle();

            NavigationUI NavigationUI = new NavigationUI(driver);
            NavigationUI.clickMyList();

            MyListPageObject MyListPageObject = new MyListPageObject(driver);
            MyListPageObject.openFolderByName(name_of_folder);
            MyListPageObject.swipeByArticleToDelete(article_title);
        }

    @Test
    public void testAmountOfNotEmptySearch() {
        SearchPageObject SearchPageObject = new SearchPageObject(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        int amount_of_search_results=SearchPageObject.getAmountOfFoundArticles();

        assertTrue(
                "We found few results",
                amount_of_search_results >0
        );
    }

    @Test
    public void testofEmptySearch() {
        SearchPageObject SearchPageObject = new SearchPageObject(driver);
        SearchPageObject.initSearchInput();
        String search_line = "zxcv43534bbn";
        SearchPageObject.typeSearchLine(search_line);
        SearchPageObject.waitForEmptyResultsLabel();
        SearchPageObject.assertNoResult();

    }


    @Test
    public void testChangeScreenOrientation() {
        SearchPageObject SearchPageObject = new SearchPageObject(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.clickByArticleWithSubstring("Object-oriented programming language");

        ArticlePageObject  ArticlePageObject = new ArticlePageObject(driver);

        String title_before_rotation = ArticlePageObject.getArticleTitle();
        this.rotateScreenLandscape();
        String title_after_rotation = ArticlePageObject.getArticleTitle();

       assertEquals(
        "Article title have been changed after rotation",
                title_before_rotation,
                title_after_rotation
                );

      this.rotateScreenPortrait();
        String title_after_second_rotation = ArticlePageObject.getArticleTitle();

        assertEquals(
                "Article title have been changed after rotation",
                title_before_rotation,
                title_after_second_rotation
        );

    }
@Test
    public void testCheckSearchArticleBackground () {
    SearchPageObject SearchPageObject = new SearchPageObject(driver);
    SearchPageObject.initSearchInput();
    SearchPageObject.typeSearchLine("Java");
    SearchPageObject.waitForSearchResult("Object-oriented programming language");
    this.backgroundApp(2);
    SearchPageObject.waitForSearchResult("Object-oriented programming language");

    }


}



