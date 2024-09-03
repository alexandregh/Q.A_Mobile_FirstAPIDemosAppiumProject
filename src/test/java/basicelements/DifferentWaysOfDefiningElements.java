import createcapabilitdriversession.CreateDriverSession;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DifferentWaysOfDefiningElements {
    @FindBy (id = "android:id/text1") private static WebElement elementByIdFindBy;
    @FindBy (className = "android.widget.TextView") private static WebElement elementByClassNameFindBy;
    @FindBy (xpath = "//android.widget.TextView[@content-desc=\"Accessibility\"]") private static WebElement elementByXPathFindBy;
    @AndroidFindBy (id = "android:id/text1") private static WebElement elementByIdAndroidFindBy;
    @AndroidFindBy (className = "android.widget.TextView") private static WebElement elementByClassNameAndroidFindBy;
    @AndroidFindBy (xpath = "//android.widget.TextView[@content-desc=\"Accessibility\"]") private static WebElement elementByXPathAndroidFindBy;
    private static WebElement element;
    public DifferentWaysOfDefiningElements(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    public static void main(String[] args) throws Exception {
        AppiumDriver driver = CreateDriverSession.inicializeDriver("Android");
        DifferentWaysOfDefiningElements differentWaysOfDefiningElements = new DifferentWaysOfDefiningElements(driver);

        System.out.println("### By PageFactory ###" + "\n");

        System.out.println("PageFactory FindBy: ");
        System.out.println("PageFactory FindBy By Id: " + elementByIdFindBy);
        System.out.println("PageFactory FindBy By ClassName: " + elementByClassNameFindBy.getText());
        System.out.println("PageFactory FindBy By XPath: " + elementByXPathFindBy);

        System.out.println("\n" + "PageFactory AndroidFindBy: ");
        System.out.println("PageFactory AndroidFindBy By Id: " + elementByIdFindBy);
        System.out.println("PageFactory AndroidFindBy By ClassName: " + elementByClassNameFindBy.getText());
        System.out.println("PageFactory AndroidFindBy By XPath: " + elementByXPathFindBy);
    }
}
