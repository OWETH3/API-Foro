package com.alura.api.Model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface ICommentModel extends JpaRepository<commentsModel, Long> {

}
