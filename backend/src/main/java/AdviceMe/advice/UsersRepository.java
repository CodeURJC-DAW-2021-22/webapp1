package AdviceMe.advice;

import org.springframework.data.jpa.repository.JpaRepository;

import Entities.Customer;

public interface UsersRepository extends JpaRepository<Customer, Long> {

}