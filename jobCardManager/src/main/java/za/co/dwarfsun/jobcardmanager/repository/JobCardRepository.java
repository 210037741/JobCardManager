/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package za.co.dwarfsun.jobcardmanager.repository;

import za.co.dwarfsun.jobcardmanager.domain.JobCard;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 *
 * @author Matthew
 */
public interface JobCardRepository extends JpaRepository<JobCard, Long>{
    
}
