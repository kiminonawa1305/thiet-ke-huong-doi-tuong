package model_food;

public abstract class Foods implements Food {
	protected String urlImage;

	@Override
	public String note() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public abstract boolean hasSize();

	public String getUrlImage() {
		return urlImage;
	}

	public void setUrlImage(String urlImage) {
		this.urlImage = urlImage;
	}
}
