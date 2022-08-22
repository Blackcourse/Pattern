package ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class SearchPageObject extends MainPageObject {
    private static final String
    SEARCH_INIT_ELEMENT = "//*[contains (@text,'Search Wikipedia')]",
            SEARCH_INPUT = "//*[contains (@text,'Search…')]",
            SEARCH_CANCEL_BUTTON = "org.wikipedia:id/search_close_btn",
            SEARCH_RESULT_BY_SUBSTRING_TPL = "//*[@resource-id ='org.wikipedia:id/page_list_item_container']//*[@text='{SUBSTRING}']",
            SEARCH_RESULT_ELEMENT =  "//*[@resource-id='org.wikipedia:id/search_results_list']",
            SEARCH_EMPTY_RESULT_ELEMENT = "//*[@text = 'No results found']";

    public SearchPageObject (AppiumDriver driver)
    {
        super(driver);
    }
    /*Templates methods */
    private static String getResultSearchElement (String substring)
    {
        return SEARCH_RESULT_BY_SUBSTRING_TPL.replace("{SUBSTRING}", substring);
    }
    /*Templates methods */
    public void initSearchInput() {
        this.waitForElementPresent(By.xpath(SEARCH_INIT_ELEMENT), "Cannot find search input after clicking search init element");
        this.waitForElementAndClick(By.xpath(SEARCH_INIT_ELEMENT), "Cannot find and click search init element", 5);
    }
    public void waitCancelButtonToAppear ()
    {
        this.waitForElementPresent(By.id(SEARCH_CANCEL_BUTTON), "Cannot find search cancel button", 5);

    }
    public void clickCancelSearch ()
    {
        this.waitForElementAndClick(By.id(SEARCH_CANCEL_BUTTON),"Can't click on element",5);
    }

    public void typeSearchLine (String search_line)
    {
        this.waitForElementAndSendKeys(By.xpath(SEARCH_INPUT),search_line, "Cannot find and type into search input", 5);
    }
    public void waitForSearchResult (String substring) {
        String search_result_xpath = getResultSearchElement(substring);
        this.waitForElementPresent (By.xpath(search_result_xpath), "Cannot find search result"+substring);
    }
    public void clickByArticleWithSubstring (String substring) {
        String search_result_xpath = getResultSearchElement(substring);
        this.waitForElementAndClick (By.xpath(search_result_xpath), "Cannot find and click search result"+substring,10);
    }
    public int getAmountOfFoundArticles ()
    {
        this.waitForElementPresent(
                By.xpath(SEARCH_RESULT_ELEMENT),
                "cannt find anything",
                15
        );
        return this.getAmountOfElements(By.xpath(SEARCH_RESULT_ELEMENT));

    }
    public void waitForEmptyResultsLabel ()
    {
        this.waitForElementPresent(By.xpath(SEARCH_EMPTY_RESULT_ELEMENT),"Ccannot find empty result element",15);


    }
    public void assertNoResult ()
    {
        this.assertElementNotPresent(By.xpath(SEARCH_RESULT_ELEMENT),"We supposed not find any results");
    }




}
