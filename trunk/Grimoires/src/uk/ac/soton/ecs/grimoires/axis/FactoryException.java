
package uk.ac.soton.ecs.grimoires.axis;

public class FactoryException extends Exception {
    private String why;
    private Exception whye;
    
    public FactoryException (Exception whye) {
	this.whye=whye;
    }
    public FactoryException (String why) {
	this.why=why;
    }
}
