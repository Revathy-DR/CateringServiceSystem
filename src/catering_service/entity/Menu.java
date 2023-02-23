package catering_service.entity;

public class Menu {
	
	private int menuId;
	private MenuType menuType;
	private String menuName;
	private String menuStatus;
	private int price;
	
	public Menu() {
		super();
	}
	
	public Menu(int menuId, MenuType menuType, String menuName, String menuStatus, int price) {
		super();
		this.menuId = menuId;
		this.menuType = menuType;
		this.menuName = menuName;
		this.menuStatus = menuStatus;
		this.price = price;
	}
	
	public int getMenuId() {
		return menuId;
	}
	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}
	public MenuType getMenuType() {
		return menuType;
	}
	public void setMenuType(MenuType menuType) {
		this.menuType = menuType;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public String getMenuStatus() {
		return menuStatus;
	}
	public void setMenuStatus(String menuStatus) {
		this.menuStatus = menuStatus;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
}