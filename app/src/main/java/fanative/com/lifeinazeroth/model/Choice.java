package fanative.com.lifeinazeroth.model;

public class Choice {
    private String mText;
    private int mPageNumber;

    public Choice(String text, int page){
        mText = text;
        mPageNumber = page;
    }

    public String getText() {
        return mText;
    }

    public void setText(String text) {
        mText = text;
    }

    public int getPageNumber() {
        return mPageNumber;
    }

    public void setPageNumber(int pageNumber) {
        mPageNumber = pageNumber;
    }
}
