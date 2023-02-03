package com.zerotohero;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import com.zerotohero.pages.ToDoListPage;

public class AutomatedTests {

    /**
     * Checks if it is possible to add a series of to-do tasks, which
     * for the simulated user, should be completed secuentially. 
     * Afterwards the complete list is cleared.
     * 
     */
    @Test
    public void FullToDoListCompletion() {
        ToDoListPage page = new ToDoListPage("https://todomvc.com/examples/vue/");

        WebElement inputBox = page.getInputBox();

        // Creating and entering the todo's
        String[] inputText = {
                "1. Start working at Endava.",

                "2. Begin your training with Edinson Sensei in his course " +
                        "\"QA Automationfrom zero to hero\".",

                "3. Go through all the challenges that appear in the way, " +
                        "remember you only get \"viga\" at automation after a LOT of practice",

                "4. Successfully complete the course.",

                "5. Congratulations now you are worth about 0.001% Edinson Sensei. " +
                        "To get better and become if most about 50% him, you must keep and keep " +
                        "practicing for the rest of your life, good luck."
        };
        for (String toDoElement : inputText)
            inputBox.sendKeys(toDoElement, Keys.ENTER);

        // Checking every todo item
        List<WebElement> listItems = page.getToDoListItems();
        listItems.stream().forEach(item -> page.getToDoItemCheckBox(item).click());

        SoftAssertions.assertSoftly(softly -> {

            // Assertions for the todo list items
            int index = 0;
            for (WebElement item : listItems) {

                String actualItemText = page.getToDoItemText(item).getText();

                softly.assertThat(item.getAttribute("class"))
                        .describedAs("The item number " + (index + 1) + "\" should be checked.")
                        .isEqualTo("todo completed");

                softly.assertThat(actualItemText)
                        .describedAs("The item's text is not equal to the actual input.")
                        .isEqualTo(inputText[index]);
                index++;
            }

            // Assertion for the items left counter
            softly.assertThat(page.getTodoItemsCount().getText().split(" ")[0])
                    .describedAs("The item counter should be 0.")
                    .isEqualTo("0");
        });

        // Clearing all the items
        page.getClearCompletedButton().click();

        // Asserting no items are shown in the page
        assertThat(page.areTheToDoItemsPresent())
                .describedAs("No items should be present after clearing the enitre list")
                .isFalse();
    }
}
