package com.senla.courses.project.dao.comparators;

import com.senla.courses.project.model.User;

import java.util.Comparator;

public class UserSurnameComparator implements Comparator<User> {
    @Override
    public int compare(User o1, User o2) {
        if(o1.getSurname() == null && o2.getSurname() == null)return 0;
        if(o1.getSurname() == null)return -1;
        if(o2.getSurname() == null)return 1;

        return o1.getSurname().compareTo(o2.getSurname());
    }
}
