package Model;

public class JobRecyclerViewModel {
    String title,exp;
    int image;

    public JobRecyclerViewModel(String title,String exp,int image) {
        this.title = title;
        this.exp=exp;
        this.image=image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getExp() {
        return exp;
    }

    public void setExp(String exp) {
        this.exp = exp;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
