package tests.todomvc.page;

import static com.codeborne.selenide.Selenide.page;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.codeborne.selenide.SelenideElement;

public class TodoMvcPage {
    @FindBy(how = How.ID, using = "new-todo")
    private SelenideElement newTodoInput;

    @FindBy(how = How.CSS, using = ".view label")
    private List<SelenideElement> viewLables;

    public TodoMvcPage addTask(String task) {
        newTodoInput.setValue(task).pressEnter();
        return page(TodoMvcPage.class);
    }

    public List<String> getViewLabelTexts() {
        return this.viewLables.stream().map(o -> o.getText()).collect(Collectors.toList());
    }
}
