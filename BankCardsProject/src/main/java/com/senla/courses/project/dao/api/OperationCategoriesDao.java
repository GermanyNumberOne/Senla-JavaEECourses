package com.senla.courses.project.dao.api;

import com.senla.courses.project.model.OperationCategory;

public interface OperationCategoriesDao extends Dao<OperationCategory> {
    OperationCategory getCategoryByName(String name);
}
