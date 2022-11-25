package Model;

public class HomeViewPagerModel {
    private int image;
    private String desc;

    public HomeViewPagerModel(int image,String desc) {
        this.image = image;
        this.desc=desc;
    }

    public int getImage() {
        return image;
    }

    public String getDesc() {
        return desc;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
