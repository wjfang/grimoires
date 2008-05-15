/*
 * Created on 14-Jun-2005
 * 
 */
package uk.ac.soton.ecs.grimoires.shell;

/**
 * @author wf
 * 
 */
public interface Command {
//    public void run() throws Exception;
	
	/*
	 * Read the input.
	 */
	public void expect() throws Exception;
	
	/*
	 * Do the processing.
	 */
	public void execute() throws Exception;
	
	/*
	 * Present the output.
	 */
	public void present() throws Exception;
}
