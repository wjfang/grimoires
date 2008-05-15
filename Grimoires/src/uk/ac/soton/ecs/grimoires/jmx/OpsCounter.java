package uk.ac.soton.ecs.grimoires.jmx;

public class OpsCounter {
	
	private OpsCounter() {
		
    }

    private static class LazyHolder {
        private static final OpsCounter singleton = new OpsCounter();
    }

    public static OpsCounter getInstance() {
        return LazyHolder.singleton;
    }
    
    private volatile int queryAndTranslateOps;
    
    public final void incQueryAndTranslateOps() {
    	queryAndTranslateOps++;
    }
    
    public final int getQueryAndTranslateOps() {
    	return queryAndTranslateOps;
    }
}
