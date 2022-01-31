package com.senla.courses.project.dao.comparators;

import com.senla.courses.project.model.User;

import java.util.Comparator;

public class UserCardsAmountComparator implements Comparator<User> {
    @Override
    public int compare(User o1, User o2) {
        return o1.getUserCards().size() - o2.getUserCards().size();
    }
}
