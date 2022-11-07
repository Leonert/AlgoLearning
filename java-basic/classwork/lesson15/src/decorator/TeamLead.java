package decorator;

public class TeamLead extends DeveloperDecorator {

	public TeamLead(Developer developer) {
		super(developer);
	}

	public String sendWeekReport() {
		return " Send week report to manager.";
	}

	@Override
	public String doJob() {
		return super.doJob() + sendWeekReport();
	}
}
