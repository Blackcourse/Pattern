package ui;

import io.appium.java_client.AppiumDriver;
import org.apache.xpath.objects.XString;
import org.openqa.selenium.By;

public class MyListPageObject extends  MainPageObject{
    public static final String
    FOLDER_BY_NAME_TPL = "//*[@text = '{FOLDER_NAME}']",
    ARTICLE_BY_TITLE_TPL = "//*[@text = '{TITLE}']";

    private static String getFolderXpathByName (String name_of_folder)
    {
        return FOLDER_BY_NAME_TPL.replace("{FOLDER_NAME}",name_of_folder);
    }
    private static String getSavedArticleXpathByTitle (String article_title)
    {
        return ARTICLE_BY_TITLE_TPL.replace("{TITLE}",article_title);
    }

    public MyListPageObject (AppiumDriver driver)
    {
        super(driver);
    }
    public void openFolderByName (String name_of_folder)
    {
        String folder_name_xpath =getFolderXpathByName(name_of_folder);
        this.waitForElementAndClick(
                By.xpath("//*[@text = '"+name_of_folder+"']"),
                "Cannot find created folder",
                5
        );
    }
    public void waitForArtToAppear (String article_title)
    {
        String article_xpath = getFolderXpathByName(article_title);
        this.waitForElementPresent(By.xpath(article_xpath),"Cant find saved article by title"+article_title);
    }
    public void waitForArticleToDissapearByTitle (String article_title)
    {
        String article_xpath = getFolderXpathByName(article_title);
        this.waitForElementNotPresent(By.xpath(article_xpath),"Saved article still present with title"+article_title,15);
    }

    public void swipeByArticleToDelete (String article_title)

    {
        this.waitForArtToAppear(article_title);
        String article_xpath = getFolderXpathByName(article_title);
        this.swipeElementToLeft(
            By.xpath(article_xpath),
            "cannot find saved article"

    );
        this.waitForArticleToDissapearByTitle(article_title);

    }
}
