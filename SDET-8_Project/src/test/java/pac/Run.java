package pac;

import org.testng.Assert;
import org.testng.annotations.Test;


public class Run {

@Test(retryAnalyzer = com.comcast.commonutils.ListenerRetry.class)
public void sampleTest() {
	System.out.println("execute test ");
	Assert.assertTrue(false);
}

}
