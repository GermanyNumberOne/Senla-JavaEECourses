package com.dao.api;

import com.dao.impl.ReportDaoImpl;
import com.model.BankAccount;
import com.model.Report;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.NoResultException;
import java.util.ArrayList;

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
        assertThrows(NoResultException.class, () -> {
            reportDao.read(1l);
        });
    }

    @Test
    @Transactional
    public void update(){
        create();

        Report report = reportDao.getAll().get(0);
        report.setIsSuccess(true);

        reportDao.update(report);

        assertTrue(reportDao.getAll().size() == 1);
    }

    @Test
    @Transactional
    public void delete(){
        assertThrows(NoResultException.class, () -> {
            reportDao.delete(1l);
        });
    }

}