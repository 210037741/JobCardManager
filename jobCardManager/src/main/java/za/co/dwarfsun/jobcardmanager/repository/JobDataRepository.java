/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package za.co.dwarfsun.jobcardmanager.repository;

import za.co.dwarfsun.jobcardmanager.model.JobData;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 *
 * @author Matthew
 */
public interface JobDataRepository extends JpaRepository<JobData, Long>{
    
}
