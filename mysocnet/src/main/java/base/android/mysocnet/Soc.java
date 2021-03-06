package base.android.mysocnet;

// данные для карточки
public class Soc {

    private final String description; // описание
    private final int picture;        // изображение
    private final boolean like;       // флажок

    public Soc(String description, int picture, boolean like){
        this.description = description;
        this.picture = picture;
        this.like = like;
    }

    // геттеры
    public String getDescription(){
        return description;
    }

    public int getPicture(){
        return picture;
    }

    public boolean getLike(){
        return like;
    }
}
