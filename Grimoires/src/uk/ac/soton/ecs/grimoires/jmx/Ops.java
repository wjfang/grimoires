package uk.ac.soton.ecs.grimoires.jmx;

public class Ops implements OpsMBean {

	public int getQueryAndTranslateOps() {
		return OpsCounter.getInstance().getQueryAndTranslateOps();
	}
}
