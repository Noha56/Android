package Models;

public class HomeViewPagerModel {

    int fruit;
    String title;

    public HomeViewPagerModel(String title,int fruit) {
        this.title=title;
        this.fruit = fruit;
    }

    public int getFruit() {
        return fruit;
    }

    public void setFruit(int fruit) {
        this.fruit = fruit;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
