public class Button {


    public interface OnClickListener{
        public abstract void onClick();
    }

    OnClickListener mOnClickListener;


    public void setOnClickListener(OnClickListener listener) {
        this.mOnClickListener = listener;
    }
    public void onClick(){
        mOnClickListener.onClick();
    }

    public static void main(String[] args) {
        Button button = new Button();
        Activity activity = new Activity(button);
        activity.onCreate();
        button.onClick();
    }
}
