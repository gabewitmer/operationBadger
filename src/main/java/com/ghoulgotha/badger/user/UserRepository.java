package com.ghoulgotha.badger.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	@Query("SELECT u FROM User u WHERE u.username=:uname")
	public User findByUsername(@Param("uname") String username);

	@Query("SELECT COUNT(u.id) FROM User u WHERE u.id<>:id AND u.username=:username OR u.id<>:id AND u.displayName=:displayName")
	public int canUpdate(@Param("id") Long id, @Param("username") String username, @Param("displayName") String displayName);
}
