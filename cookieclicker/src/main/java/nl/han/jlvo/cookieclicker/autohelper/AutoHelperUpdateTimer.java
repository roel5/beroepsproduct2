package nl.han.jlvo.cookieclicker.autohelper;

import nl.han.ica.oopg.alarm.Alarm;
import nl.han.ica.oopg.alarm.IAlarmListener;

public class AutoHelperUpdateTimer implements IAlarmListener {
    private final IAutoHelperUpdateListener listener;

    public AutoHelperUpdateTimer(IAutoHelperUpdateListener listener) {
        this.listener = listener;
        startAlarm();
    }

    private void startAlarm() {
        Alarm alarm = new Alarm(this.getClass().getName(), 1);
        alarm.addTarget(this);
    }

    @Override
    public void triggerAlarm(String s) {
        listener.onAutoHelperUpdate();
        startAlarm();
    }
}
