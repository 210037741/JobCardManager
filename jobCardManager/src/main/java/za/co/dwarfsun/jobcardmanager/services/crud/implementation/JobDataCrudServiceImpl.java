/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package za.co.dwarfsun.jobcardmanager.services.crud.implementation;

import za.co.dwarfsun.jobcardmanager.domain.JobData;
import za.co.dwarfsun.jobcardmanager.repository.GenericDAO;
import za.co.dwarfsun.jobcardmanager.services.crud.JobDataCrudService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Matthew
 */
@Service("jobDataCrudService")
@Transactional
public class JobDataCrudServiceImpl  implements JobDataCrudService{
    @Autowired
    private GenericDAO<JobData> dao;
    
    public final void setDao(final GenericDAO<JobData> daoToSet) {
        this.dao = daoToSet;
        this.dao.setClazz(JobData.class);
    }

    @Override
    public JobData find(Long id) {
       setDao(dao);
        return dao.findById(id);
    }

    @Override
    public JobData persist(JobData entity) {
        setDao(dao);
        dao.merge(entity);
        return (entity);
    }

    @Override
    public JobData merge(JobData entity) {
        setDao(dao);
        dao.merge(entity);
        return (entity);
    }

    @Override
    public void remove(JobData entity) {
        setDao(dao);
        dao.remove(entity);
    }

    @Override
    public List<JobData> findAll() {
        setDao(dao);
        return dao.findAll();
    }
}
