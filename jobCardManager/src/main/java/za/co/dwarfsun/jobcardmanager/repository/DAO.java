/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package za.co.dwarfsun.jobcardmanager.repository;

import java.util.List;

/**
 *
 * @author 208176454
 */
public interface DAO <T, ID> {

    public T findById(final ID id);

    public List<T> findAll();

    public void persist(final T entity);

    public void merge(final T entity);

    public void remove(final T entity);
}
    

