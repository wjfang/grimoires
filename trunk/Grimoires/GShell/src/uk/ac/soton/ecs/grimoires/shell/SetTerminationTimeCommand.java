package uk.ac.soton.ecs.grimoires.shell;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class SetTerminationTimeCommand extends Shell implements Command {

	private String key;
	private String keyType;
	private String input;
	private String metadataValue;
	private String metadataType = 
		uk.ac.soton.ecs.grimoires.server.lifetime.Constants.TerminationTimeMetadataType;

	public SetTerminationTimeCommand() {
		// TODO Auto-generated constructor stub
	}

	public SetTerminationTimeCommand(String key, String type, String input) {
		this.key = key;
		this.keyType = type;
		this.input = input;
	}

	private String calculateTerminationTime(String input) throws GShellException {
		DateFormat dfi = DateFormat.getDateTimeInstance(
				DateFormat.SHORT, DateFormat.MEDIUM, Locale.UK);
		DateFormat dfo = DateFormat.getDateTimeInstance(
				DateFormat.FULL, DateFormat.FULL, Locale.ENGLISH);
		Date d = null;
		try {
			d = dfi.parse(input);
		} catch (ParseException e) {
			try {
				int s = Integer.valueOf(input);
				Calendar c = Calendar.getInstance();
				c.add(Calendar.SECOND, s);
				d = c.getTime();
			} catch (NumberFormatException e1) {
				throw new GShellException("Cannot interpret input as either an absolute time or a lifetime.");
			}
		}		
		return dfo.format(d);	
	}
	
	public void execute() throws Exception {
		/*
		 * Calculate termination time based on lifetime.
		 */
		metadataValue = calculateTerminationTime(input);

		if (keyType.equals("business")) {
        	grimoiresProxy.attachMetadataToBusiness(metadataType , metadataValue, key);        	            
        } else if (keyType.equals("service")) {
            grimoiresProxy.attachMetadataToService(metadataType, metadataValue, key);
        } else if (keyType.equals("metadata")) {
            grimoiresProxy.attachMetadataToMetadata(metadataType, metadataValue, key);
        }
	}

	public void expect() throws Exception {
		out.println("==== Set the termination time to a keyed entity ====");
        out.println("Input the entity key:");
        key = readAndParseLine();
        out.println("Input the key type (business, service, or metadata):");
        keyType = readAndParseLine();
        out.println("Input the lifetime in seconds since now, " +
        		"or the desired termination time in the format \"dd/mm/yy hh:mm:ss\":");
        input = readAndParseLine();
	}

	public void present() throws Exception {
		out.println("The entity will expire on " + metadataValue);
	}
	
	private void present2() throws Exception {
        System.out.println("The entity will expire on " + metadataValue);
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		setUpStubs(args[0]);
		SetTerminationTimeCommand cmd;
		try {
        	if (args.length != 4) {
				throw new java.lang.IllegalArgumentException();
        	}
        	cmd = new SetTerminationTimeCommand(args[1], args[2], args[3]);
        	cmd.execute();
            cmd.present2();            
        } catch (java.lang.IllegalArgumentException ex) {
        	help();
            System.exit(1);
        }
    }

    /**
     * 
     */
    private static void help() {
        System.out.println("java SetTerminationTimeCommand Grimoires_URL " +
                "key [business|service] lifetime_in_seconds");
	}

}
