package uk.ac.soton.ecs.grimoires.server.impl.xmlview.xslt;

public class MyGridToGrimoiresTest {
//	private static String inputDir = "mygrid/description/";
	private static String inputDir = "Feta/service-desc/alignment/";
	private static String xsltDir = "mygrid/xslt/";
	private static String outputDir = "mygrid/transformed/";

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		String inputFile = null;
		if (args.length != 1)
			inputFile = "alignment_global-needle.xml";
		else
			inputFile = args[0];
		
		DOM2DOM d2d = new DOM2DOM(xsltDir + "toUDDIBusiness.xsl");
		d2d.transform(inputDir + inputFile);
		d2d = new DOM2DOM(xsltDir + "toUDDIService.xsl");
		d2d.transform(inputDir + inputFile);
		d2d = new DOM2DOM(xsltDir + "toUDDITModel.xsl");
		d2d.transform(inputDir + inputFile);
		d2d = new DOM2DOM(xsltDir + "toWSDL.xsl");
		d2d.transform(inputDir + inputFile);
	}
	
	/**
	 * 
	 * @param inputFile e.g., 3DbWhat.xml
	 * @return 3DbWhat.wsdl
	 */
	private static String generateWSDLFileName(String inputFile) {
		String[] ss = inputFile.split("\\.");
		return ss[0] + ".wsdl";
	}

	/**
	 * 
	 * @param inputFilename e.g., 3DbWhat.xml
	 * @param pattern e.g., UDDIBusiness
	 * @return 3DbWhat-UDDIBusiness.xml
	 */
	private static String generateOutputFileName(String inputFile, String pattern) {
		String[] ss = inputFile.split("\\.");
		return ss[0] + "-" + pattern + "." + ss[1];
	}
}
