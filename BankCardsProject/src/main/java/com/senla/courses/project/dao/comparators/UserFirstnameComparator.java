package com.senla.courses.project.dao.comparators;

import com.senla.courses.project.model.User;

import java.util.Comparator;

public class UserFirstnameComparator implements Comparator<User> {
    @Override
    public int compare(User o1, User o2) {
        if(o1.getFirstname() == null && o2.getFirstname() == null)return 0;
        if(o1.getFirstname() == null)return -1;
        if(o2.getFirstname() == null)return 1;

        return o1.getFirstname().compareTo(o2.getFirstname());
    }
}
