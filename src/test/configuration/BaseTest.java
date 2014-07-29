import com.opera.test.common.WebDriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

/**
 * Created with IntelliJ IDEA.
 * User: IGulyam
 * Date: 29.07.14
 * Time: 15:29
 * To change this template use File | Settings | File Templates.
 */
@ContextConfiguration(locations = {"classpath:context.xml"})
public class BaseTest extends AbstractTestNGSpringContextTests {

    @Autowired
    protected WebDriverService webDriverService;

    private String time;

    @BeforeMethod
    public void setUp() {

    }


    @AfterMethod
    public void finalize() {

    }


}
