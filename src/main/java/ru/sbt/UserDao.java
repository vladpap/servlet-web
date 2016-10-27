package ru.sbt;

/**
 * Created by user18 on 27.10.2016.
 */
public interface UserDao {

    boolean isPasswordCorrect(String name, int password);
}
