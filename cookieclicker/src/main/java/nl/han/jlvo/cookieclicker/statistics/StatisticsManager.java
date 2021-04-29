package nl.han.jlvo.cookieclicker.statistics;

import java.time.LocalDateTime;

public class StatisticsManager {
    float totalAmountOfCookies = 0;
    int totalAmountOfClicks = 0;
    int totalAmountOfGoldenCookies = 0;
    int totalAmountOfVerminDied = 0;
    float totalAmountOfCookiesEatenByVermin = 0;
    int totalAmountOfHelpers = 0;
    LocalDateTime gameStartTime;

    public float getTotalAmountOfCookies() {
        return totalAmountOfCookies;
    }

    public void increaseTotalAmountOfCookies(float amount) {
        totalAmountOfCookies += amount;
    }

    public int getTotalAmountOfClicks() {
        return totalAmountOfClicks;
    }

    public void increaseTotalAmountOfClicks(float cookiesForClick) {
        totalAmountOfClicks++;
        increaseTotalAmountOfCookies(cookiesForClick);
    }

    public int getTotalAmountOfGoldenCookies() {
        return totalAmountOfGoldenCookies;
    }

    public void increaseTotalAmountOfGoldenCookies() {
        totalAmountOfGoldenCookies++;
    }

    public void setGameStartTime(LocalDateTime gameStartTime) {
        this.gameStartTime = gameStartTime;
    }

    public LocalDateTime getGameStartTime() {
        return gameStartTime;
    }

    public int getTotalAmountOfVerminDied() {
        return totalAmountOfVerminDied;
    }

    public void IncreaseTotalAmountOfVerminDied() {
        totalAmountOfVerminDied++;
    }

    public void increaseTotalAmountOfCookiesEatenByVermin(float cookies) {
        totalAmountOfCookiesEatenByVermin = cookies;
    }

    public float getTotalAmountOfCookiesEatenByVermin() {
        return totalAmountOfCookiesEatenByVermin;
    }

    public int getTotalAmountOfHelpers() {
        return totalAmountOfHelpers;
    }

    public void increaseTotalAmountOfHelpers() {
        totalAmountOfHelpers++;
    }
}
