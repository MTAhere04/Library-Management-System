package library;

public class Book {
    private String Author;
    private String Title;
    private int Serial ;
    private boolean isAvailable=true;
    public void setAvailable(boolean available) {
        isAvailable = available;
    }


    public Book(String Title,String Author,int Serial){
        this.Author=Author;
        this.Title=Title;
        this.Serial=Serial;
    }
    public String getAuthor() {
        return Author;
    }
    public String getTitle(){
        return Title;
    }
    public int getSerial(){
        return Serial;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public void setSerial(int serial) {
        Serial = serial;
    }
    public boolean isAvailable(){
        return isAvailable;
    }

}
