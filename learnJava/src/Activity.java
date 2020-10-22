public class Activity {
    private Button mButton;
    public Activity(Button button){
        mButton = button;
    }
    public void setButton(Button button) {
        mButton = button;
    }

    public void onCreate() {
        mButton.setOnClickListener(()-> System.out.println("Clicked!"));
    }
}
