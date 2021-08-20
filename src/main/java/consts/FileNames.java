package consts;

public enum FileNames {
    GENRE("/Genre.json","genre","genres"),
    GENRE_WRONG("/GenreWrong.json","genre","genres"),
    AUTHOR("/Author.json","author","authors"),
    AUTHOR_WRONG("/AuthorWrong.json","author","authors"),
    BOOK("/Book.json","book","books"),
    BOOK_WRONG("/BookWrong.json","book","books"),
    VERIFY("/verifyUpdate.json","","");

    private final String name;
    private final String findOne;
    private final String findAll;

    FileNames(String name,String findOne,String findAll){
        this.name=name;
        this.findOne=findOne;
        this.findAll=findAll;
    }

    public String getName() {
        return name;
    }
    public String getFindOne() {
        return findOne;
    }

    public String getFindAll() {
        return findAll;
    }
}
