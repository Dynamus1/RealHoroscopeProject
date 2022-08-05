package com.util;

public class CurrentHoroscopeUser {

    public static CurrentHoroscopeUser currentHoroscopeUser;
    private static Integer horoscope_user_id;

    private static String first_name;

    private static String last_name;

    private static String email;

    private static String username;

    private static String passw;

    private static String horoscope;

    private static String mood;

    public CurrentHoroscopeUser() {}

    public CurrentHoroscopeUser(Integer horoscope_user_id, String first_name, String last_name, String email, String username, String passw, String horoscope, String mood) {
        this.horoscope_user_id = horoscope_user_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.username = username;
        this.passw = passw;
        this.horoscope = horoscope;
        this.mood = mood;
    }

    public CurrentHoroscopeUser(Integer horoscope_user_id, String first_name, String last_name, String email, String username, String passw, String horoscope) {
        this.horoscope_user_id = horoscope_user_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.username = username;
        this.passw = passw;
        this.horoscope = horoscope;
    }


    public static CurrentHoroscopeUser getCurrentHoroscopeUser() {
        return currentHoroscopeUser;
    }

    public static void setCurrentHoroscopeUser(CurrentHoroscopeUser currentHoroscopeUser) {
        CurrentHoroscopeUser.currentHoroscopeUser = currentHoroscopeUser;
    }

    public static Integer getHoroscope_user_id() {
        return horoscope_user_id;
    }

    public static void setHoroscope_user_id(Integer horoscope_user_id) {
        CurrentHoroscopeUser.horoscope_user_id = horoscope_user_id;
    }

    public static String getFirst_name() {
        return first_name;
    }

    public static void setFirst_name(String first_name) {
        CurrentHoroscopeUser.first_name = first_name;
    }

    public static String getLast_name() {
        return last_name;
    }

    public static void setLast_name(String last_name) {
        CurrentHoroscopeUser.last_name = last_name;
    }

    public static String getEmail() {
        return email;
    }

    public static void setEmail(String email) {
        CurrentHoroscopeUser.email = email;
    }

    public static String getUsername() {
        return username;
    }

    public static void setUsername(String username) {
        CurrentHoroscopeUser.username = username;
    }

    public static String getPassw() {
        return passw;
    }

    public static void setPassw(String passw) {
        CurrentHoroscopeUser.passw = passw;
    }

    public static String getHoroscope() {
        return horoscope;
    }

    public static void setHoroscope(String horoscope) {
        CurrentHoroscopeUser.horoscope = horoscope;
    }

    public static String getMood() {
        return mood;
    }

    public static void setMood(String mood) {
        CurrentHoroscopeUser.mood = mood;
    }
}
