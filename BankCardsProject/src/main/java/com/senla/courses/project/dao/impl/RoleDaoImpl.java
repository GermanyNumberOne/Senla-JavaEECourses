package com.senla.courses.project.dao.impl;

import com.senla.courses.project.dao.api.RoleDao;
import com.senla.courses.project.model.Role;
import org.springframework.stereotype.Repository;

@Repository
public class RoleDaoImpl extends AbstractDao<Role> implements RoleDao {
    @Override
    protected Class<Role> getEntityClass() {
        return Role.class;
    }
}
