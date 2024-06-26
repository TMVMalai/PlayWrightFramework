package org.playwright.pages;

public class DemoPage extends BaseClass {

    public DemoPage(Page page) {
        super(page);
    }

    @FindBy(xpath = "//a[text()='Joe.Root']//parent::td/..//following-sibling::td//input[@type='checkbox']")
    private Locator element;

    @FindBy(xpath = "//div[text()='Login']")
    private Locator loginButton;

    @FindBy(xpath = "//a[text()='Username']//ancestor::thead/following-sibling::tbody//tr//td[2]")
    private Locator userNames;

    @FindBy(xpath = "//input[@data-testid='user-mobileno-input-box']")
    private Locator emailID;

    @FindBy(xpath = "//input[@data-testid='password-input-box-cta']")
    private Locator password;

    @FindBy(xpath = "(//div[text()='Email']//parent::div/../div[contains(@class,'css-1dbjc4n r-zso239') or (@class='css-1dbjc4n')])[1]")
    private Locator emailRadioButton;

    @FindBy(xpath = "//div[@data-testid='login-cta']")
    private Locator signIn;


    public void clickCheckBox() {
        click(element, "checkBox");
    }

    public List<String> getUserNames() {
        List<String> userNamesList = userNames.allTextContents();
        return userNamesList;
    }

    public void clickAllUserNames() {
        List<Locator> elements = getLocators(userNames);
        for (Locator ele : elements) {
            ele.click();
        }
    }

    public void clickLogin() {
        loginButton.click();
    }

    public void clickEmailRadioButton() {
        emailRadioButton.click();
    }

    public void sendEmail(String email) {
        emailID.fill(email);
    }

    public void sendpassword(String Password) {
        password.fill(Password);
    }

    public void clickSignInButton() {
        signIn.click();
    }
}
