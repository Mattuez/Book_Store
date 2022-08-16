public class Book {
    private String name;
    private String author;
    private String code;
    private int pages;
    private double price;
    private String language;
    private int quantity;

    public Book(String name, String author, String code, int pages, double price, String language, int quantity) {
        this.setName(name);
        this.setAuthor(author);
        this.setCode(code);
        this.setPrice(price);
        this.setPages(pages);
        this.setLanguage(language);
        this.setQuantity(quantity);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
