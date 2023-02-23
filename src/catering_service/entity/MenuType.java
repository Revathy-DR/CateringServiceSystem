package catering_service.entity;

public class MenuType {
	
	private int menuTypeId;
	private String typeName;
	private String description;
	public MenuType(int menuTypeId, String typeName, String description) {
		super();
		this.menuTypeId = menuTypeId;
		this.typeName = typeName;
		this.description = description;
	}
	public MenuType() {
		super();
	}
	public int getMenuTypeId() {
		return menuTypeId;
	}
	public void setMenuTypeId(int menuTypeId) {
		this.menuTypeId = menuTypeId;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}	

}
