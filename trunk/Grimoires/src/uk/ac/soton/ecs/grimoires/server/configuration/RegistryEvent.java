package uk.ac.soton.ecs.grimoires.server.configuration;

public class RegistryEvent {
	static public final int SAVE_BUSINESS_EVENT_TYPE = 10;	
	static public final int DELETE_BUSINESS_EVENT_TYPE = 11;
	static public final int SAVE_SERVICE_EVENT_TYPE = 20;
	static public final int DELETE_SERVICE_EVENT_TYPE = 21;
	static public final int SAVE_WSDL_EVENT_TYPE = 30;
	static public final int DELETE_WSDL_EVENT_TYPE = 31;
	static public final int ATTACH_METADATA_EVENT_TYPE = 40;
	static public final int DELETE_METADATA_EVENT_TYPE = 41;
	static public final int SAVE_BINDING_EVENT_TYPE = 50;	
	static public final int DELETE_BINDING_EVENT_TYPE = 51;
	static public final int SAVE_TMODEL_EVENT_TYPE = 60;	
	static public final int DELETE_TMODEL_EVENT_TYPE = 61;
	
	private int type;
	
	private Object data;
	
	public RegistryEvent(int type, Object data) {
		this.type = type;
		this.data = data;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}
}
