package fanative.com.lifeinazeroth.model;


public class Page {
    private int mIntId;
    private String mText;
    private Choice mChoice1;
    private Choice mChoice2;
    private boolean mIsFinal = false;

    public Page(int ID, String text, Choice one, Choice two){
        mIntId = ID;
        mText = text;
        mChoice1 = one;
        mChoice2 = two;
    }

    public Page(int ID, String text){
        mIntId = ID;
        mText = text;
        mChoice1 = null;
        mChoice2 = null;
        mIsFinal = true;
    }

    public int getIntId(){
        return mIntId;
    }

    public void setIntId(int x){
        mIntId = x;
    }

    public String getText() {
        return mText;
    }

    public void setText(String text) {
        mText = text;
    }

    public Choice getChoice2() {
        return mChoice2;
    }

    public void setChoice2(Choice choice2) {
        mChoice2 = choice2;
    }

    public Choice getChoice1() {
        return mChoice1;
    }

    public void setChoice1(Choice choice1) {
        mChoice1 = choice1;
    }

    public boolean isFinal() {
        return mIsFinal;
    }

    public void setIsFinal(boolean isFinal) {
        mIsFinal = isFinal;
    }
}
