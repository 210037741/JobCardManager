/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package za.co.dwarfsun.jobcardmanager.repository;

import java.io.Serializable;

/**
 *
 * @author 208176454
 * @param <T>
 * 
 */
public interface GenericDAO < T extends Serializable > extends DAO< T, Long>{
        void setClazz( final Class< T > clazzToSet );
    
}
