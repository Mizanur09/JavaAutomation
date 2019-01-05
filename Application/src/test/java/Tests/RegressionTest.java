package Tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses(
		{
			Test01_ConsentTest.class,
			Test02_Continue_WithOut_login_HomePage.class,
			Test03_Continue_With_Logging_In_HomePage.class,
			Test04_LogOut.class,
			
		}
			)

public class RegressionTest {}
