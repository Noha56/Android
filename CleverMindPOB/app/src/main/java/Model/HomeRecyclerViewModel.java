package Model;

public class HomeRecyclerViewModel {

    private String title,day,time,attend;
    private int image,attendIcon;


    public HomeRecyclerViewModel(String title,String day,String time,String attend,int image,int attendIcon) {
        this.title = title;
        this.day=day;
        this.time=time;
        this.attend=attend;
        this.image=image;
        this.attendIcon=attendIcon;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getAttend() {
        return attend;
    }

    public void setAttend(String attend) {
        this.attend = attend;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getAttendIcon() {
        return attendIcon;
    }

    public void setAttendIcon(int attendIcon) {
        this.attendIcon = attendIcon;
    }
}

