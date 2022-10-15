package com.job.board.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.job.board.entities.Users;

public interface UserRepository extends JpaRepository<Users,Integer>{
	@Query("select u from Users u where u.username= :username")
	public Users  getUsersByuserName(@Param("username") String username);
}
