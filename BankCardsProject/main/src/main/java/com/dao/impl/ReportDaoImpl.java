package com.dao.impl;

import com.dao.api.ReportDao;
import com.model.Report;
import org.springframework.stereotype.Repository;

@Repository
public class ReportDaoImpl extends AbstractDao<Report>  implements ReportDao {
    @Override
    protected Class<Report> getEntityClass() {
        return Report.class;
    }
}
