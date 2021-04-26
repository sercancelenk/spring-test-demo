package com.example.springtestdemo.repository;

import com.example.springtestdemo.domain.UserEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserRepository extends PagingAndSortingRepository<UserEntity, Long> {
}
