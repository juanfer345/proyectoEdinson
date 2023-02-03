package com.zerotohero.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * A class that represents the todo list page
 */
public class ToDoListPage extends Page {

    public ToDoListPage(String url) {
        super(url);
    }

    public enum Using {
        INPUT_BOX(By.cssSelector("input[placeholder*='What needs to be done?']")),
        LIST_ITEMS(By.xpath("//section[@class='main']/ul/li")),
        LIST_ITEMS_CHECKBOX(By.xpath("./div/input")),
        LIST_ITEMS_TEXT(By.xpath("./div/label")),
        TODO_ITEMS_COUNT(By.cssSelector("span[class='todo-count']")),
        CLEAR_COMPLETED_BUTTON(By.cssSelector("button[class='clear-completed']"));

        private final By selector;

        Using(By selector) {
            this.selector = selector;
        }

        public By selector() {
            return this.selector;
        }
    }

    public WebElement getInputBox() {
        return findElement(Using.INPUT_BOX.selector());
    }

    public List<WebElement> getToDoListItems() {
        return findElements(Using.LIST_ITEMS.selector());
    }

    public WebElement getToDoItemCheckBox(WebElement item) {
        return item.findElement(Using.LIST_ITEMS_CHECKBOX.selector());
    }

    public WebElement getToDoItemText(WebElement item) {
        return item.findElement(Using.LIST_ITEMS_TEXT.selector());
    }

    public WebElement getTodoItemsCount() {
        return findElement(Using.TODO_ITEMS_COUNT.selector());
    }

    public WebElement getClearCompletedButton() {
        return findElement(Using.CLEAR_COMPLETED_BUTTON.selector());
    }

    public boolean areTheToDoItemsPresent() {
        return getToDoListItems().size() != 0;
    }
}