package uk.ac.soton.ecs.grimoires.server.impl.xmlview.impl;

public class NamespaceMapping {
	
	private String prefix;
	
	private String uri;
	
	public NamespaceMapping(String prefix, String uri) {
		this.prefix = prefix;
		this.uri = uri;
	}

	public String getPrefix() {
		return prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}
	
}
