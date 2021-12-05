package com.dao.api;

import com.dao.impl.ReportDaoImpl;
import com.model.Report;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@ContextConfiguration(classes = {ReportDaoImpl.class})
class ReportDaoTest extends DaoTest {
    @Autowired
    private ReportDao reportDao;

    @Test
    @Transactional
    public void create(){
        Report report = new Report();

        reportDao.create(report);
    }

    @Test
    @Transactional
    public void read(){
        assertTrue(reportDao.read(1l) == null);
    }

    @Test
    @Transactional
    public void update(){
        Report report = new Report();

        reportDao.update(report);
    }

    @Test
    @Transactional
    public void delete(){
        reportDao.delete(1l);
    }

}