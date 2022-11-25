package Models;

public class FruitsRecyclerViewModel {
    int fruitImage;
    String fruitName,price;

    public FruitsRecyclerViewModel(int fruitImage,String fruitName,String price) {
        this.fruitImage = fruitImage;
        this.fruitName = fruitName;
        this.price = price;
    }

    public int getFruitImage() {
        return fruitImage;
    }

    public void setFruitImage(int fruitImage) {
        this.fruitImage = fruitImage;
    }

    public String getFruitName() {
        return fruitName;
    }

    public void setFruitName(String fruitName) {
        this.fruitName = fruitName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
