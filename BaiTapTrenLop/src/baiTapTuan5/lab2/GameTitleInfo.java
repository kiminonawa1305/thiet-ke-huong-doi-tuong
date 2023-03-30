package baiTapTuan5.lab2;

public class GameTitleInfo extends TitleInfo {
	public GameTitleInfo(String titleName) {
		this.setTitleName(titleName);
	}

	public String getTitleBlurb() {
		return ("Game: " + this.getTitleName());
	}
}
