package dao.impl;

import dao.DataBase;
import dao.api.ReportDao;
import dto.ReportDto;
import model.Operation;
import model.Report;
import model.Report;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ReportDaoImpl extends AbstractDao<Report> implements ReportDao {
    @Autowired
    private DataBase dataBase;

    public void create(Report entity) {
        dataBase.getReports().add(entity);
    }

    @Override
    public Report read(Long id) {
        return dataBase.getReports().get(id.intValue());
    }

    @Override
    public void update(Report entity) {
        List<Report> reports = dataBase.getReports();

        int index = -1;

        for(Report report : reports){
            if(entity.equals(report)){
                index = reports.indexOf(reports);
                break;
            }
        }

        if(index >= 0){
            reports.set(index, entity);
        }
        else create(entity);
    }

    @Override
    public void delete(Long id) {
        dataBase.getReports().remove(id.intValue());
    }
}
