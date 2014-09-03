/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package za.co.dwarfsun.jobcardmanager.services.crud.implementation;

import za.co.dwarfsun.jobcardmanager.model.JobCardAttribute;
import za.co.dwarfsun.jobcardmanager.repository.GenericDAO;
import za.co.dwarfsun.jobcardmanager.services.crud.JobCardAttributeCrudService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Matthew
 */
@Service("jobCardAttributeCrudService")
@Transactional
public class JobCardAttributeCrudServiceImpl  implements JobCardAttributeCrudService{
    @Autowired
    private GenericDAO<JobCardAttribute> dao;
    
    public final void setDao(final GenericDAO<JobCardAttribute> daoToSet) {
        this.dao = daoToSet;
        this.dao.setClazz(JobCardAttribute.class);
    }

    @Override
    public JobCardAttribute find(Long id) {
       setDao(dao);
        return dao.findById(id);
    }

    @Override
    public JobCardAttribute persist(JobCardAttribute entity) {
        setDao(dao);
        dao.merge(entity);
        return (entity);
    }

    @Override
    public JobCardAttribute merge(JobCardAttribute entity) {
        setDao(dao);
        dao.merge(entity);
        return (entity);
    }

    @Override
    public void remove(JobCardAttribute entity) {
        setDao(dao);
        dao.remove(entity);
    }

    @Override
    public List<JobCardAttribute> findAll() {
        setDao(dao);
        return dao.findAll();
    }
}
