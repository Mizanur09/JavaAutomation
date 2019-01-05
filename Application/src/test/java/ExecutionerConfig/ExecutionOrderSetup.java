package ExecutionerConfig;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.InitializationError;

public class ExecutionOrderSetup extends BlockJUnit4ClassRunner {
	
	//%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
		// %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

		// DO NOT TOUCH THIS LIBRARY

		// %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
		// %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

	public ExecutionOrderSetup(Class<?> testClass) throws InitializationError {
		super(testClass);
	}

	protected List<FrameworkMethod> computerTestMethods() {
		List<FrameworkMethod> frameworkMethods = super.computeTestMethods();
		Collections.sort(frameworkMethods, new Comparator<FrameworkMethod>() {

			@Override
			public int compare(FrameworkMethod f1, FrameworkMethod f2) {
				ExecutionOrder o1 = f1.getAnnotation(ExecutionOrder.class);
				ExecutionOrder o2 = f2.getAnnotation(ExecutionOrder.class);
				
				if(o1 == null || o2 == null)
					return -1;
				return o1.value() -o2.value();
			}
		});
		return frameworkMethods;
	}
	
	
	
}
