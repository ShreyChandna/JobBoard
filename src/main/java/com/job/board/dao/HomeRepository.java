package com.job.board.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.job.board.entities.JobDetails;
import com.job.board.entities.Users;

public interface HomeRepository extends JpaRepository<JobDetails,Integer>{
@Query("from JobDetails as a where a.user.username= :username ")
	public List<JobDetails> findJobDetailsByUser(@Param("username")String username);

@Query("select u from JobDetails u where u.jobid= :jobid")
public JobDetails  getJobDetailsByJobId(@Param("jobid") Integer jobid);
}
