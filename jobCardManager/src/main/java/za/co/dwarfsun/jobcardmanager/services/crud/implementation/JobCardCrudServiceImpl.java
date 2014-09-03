/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package za.co.dwarfsun.jobcardmanager.services.crud.implementation;

import za.co.dwarfsun.jobcardmanager.model.JobCard;
import za.co.dwarfsun.jobcardmanager.repository.GenericDAO;
import za.co.dwarfsun.jobcardmanager.services.crud.JobCardCrudService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Matthew
 */
@Service("jobCardCrudService")
@Transactional
public class JobCardCrudServiceImpl  implements JobCardCrudService{
    @Autowired
    private GenericDAO<JobCard> dao;
    
    public final void setDao(final GenericDAO<JobCard> daoToSet) {
        this.dao = daoToSet;
        this.dao.setClazz(JobCard.class);
    }

    @Override
    public JobCard find(Long id) {
       setDao(dao);
        return dao.findById(id);
    }

    @Override
    public JobCard persist(JobCard entity) {
        setDao(dao);
        dao.merge(entity);
        return (entity);
    }

    @Override
    public JobCard merge(JobCard entity) {
        setDao(dao);
        dao.merge(entity);
        return (entity);
    }

    @Override
    public void remove(JobCard entity) {
        setDao(dao);
        dao.remove(entity);
    }

    @Override
    public List<JobCard> findAll() {
        setDao(dao);
        return dao.findAll();
    }
}
