package com.senla.courses.project.dao.impl;

import com.senla.courses.project.dao.api.ReportDao;
import com.senla.courses.project.model.Report;
import org.springframework.stereotype.Repository;

@Repository
public class ReportDaoImpl extends AbstractDao<Report>  implements ReportDao {
    @Override
    protected Class<Report> getEntityClass() {
        return Report.class;
    }
}
