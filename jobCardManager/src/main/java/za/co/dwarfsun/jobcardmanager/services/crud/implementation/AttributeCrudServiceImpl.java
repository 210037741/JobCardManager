/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package za.co.dwarfsun.jobcardmanager.services.crud.implementation;

import za.co.dwarfsun.jobcardmanager.model.Attribute;
import za.co.dwarfsun.jobcardmanager.repository.GenericDAO;
import za.co.dwarfsun.jobcardmanager.services.crud.AttributeCrudService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Matthew
 */
@Service("attributeCrudService")
@Transactional
public class AttributeCrudServiceImpl  implements AttributeCrudService {
    @Autowired
    private GenericDAO<Attribute> dao;
    
    public final void setDao(final GenericDAO<Attribute> daoToSet) {
        this.dao = daoToSet;
        this.dao.setClazz(Attribute.class);
    }

    @Override
    public Attribute find(Long id) {
       setDao(dao);
        return dao.findById(id);
    }

    @Override
    public Attribute persist(Attribute entity) {
        setDao(dao);
        dao.merge(entity);
        return (entity);
    }

    @Override
    public Attribute merge(Attribute entity) {
        setDao(dao);
        dao.merge(entity);
        return (entity);
    }

    @Override
    public void remove(Attribute entity) {
        setDao(dao);
        dao.remove(entity);
    }

    @Override
    public List<Attribute> findAll() {
        setDao(dao);
        return dao.findAll();
    }
}
