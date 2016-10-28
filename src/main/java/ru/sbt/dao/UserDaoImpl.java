package ru.sbt.dao;

/**
 * Created by user18 on 27.10.2016.
 */
public class UserDaoImpl implements UserDao {
    public boolean isPasswordCorrect(String name, int passwordHash) {
        return name.equals("admin") && passwordHash == "admin".hashCode();
    }
}
