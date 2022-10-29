package monitoring;

public class LocalMonitoring implements Monitoring {

	@Override
	public void startMonitoring() {
		System.out.println("Local monitoring");
	}
}
