package nl.han.jlvo.cookieclicker.autohelper;

import java.util.Timer;
import java.util.TimerTask;

public class AutoHelperUpdateTimer {
    private final IAutoHelperUpdateListener listener;

    public AutoHelperUpdateTimer(IAutoHelperUpdateListener listener) {
        this.listener = listener;
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new AutoHelperUpdateTask(), 0, 1000);
    }

    class AutoHelperUpdateTask extends TimerTask {
        @Override
        public void run() {
            listener.onAutoHelperUpdate();
        }
    }
}
