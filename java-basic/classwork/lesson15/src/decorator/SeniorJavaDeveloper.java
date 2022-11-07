package decorator;

public class SeniorJavaDeveloper extends DeveloperDecorator {

	public SeniorJavaDeveloper(Developer developer) {
		super(developer);
	}

	public String makeCodeReview() {
		return " Do code review";
	}

	@Override
	public String doJob() {
		return super.doJob() + makeCodeReview();
	}

}
