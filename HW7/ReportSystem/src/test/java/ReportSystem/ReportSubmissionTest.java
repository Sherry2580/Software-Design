package ReportSystem;

import org.junit.jupiter.api.Test;

public class ReportSubmissionTest {
	@Test
	void testIsValidLogFileName() {
		ReportSystem reportsm = new ReportSystem(new StubLoginManager());
		boolean result = reportsm.submit("my report");
		assert(result);
	}
}
