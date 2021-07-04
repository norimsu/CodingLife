package kr.pe.norimsu.springrestdocs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import kr.pe.norimsu.springrestdocs.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    //
}
