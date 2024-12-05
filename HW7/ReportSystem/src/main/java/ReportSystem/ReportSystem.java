package ReportSystem;

public class ReportSystem {
	private LoginManager loginManager;

    public ReportSystem(LoginManager loginManager) {
        this.loginManager = loginManager;
    }

    public boolean submit(String report) {
        if (loginManager.isValid()) {
            return true;
        }
        return false;
    }
}
