package com.github.terryrao.example.axon.command.repository;

/**
 * @author raow date: 2019/9/4 19:07
 */
public interface DomainRepository<T> {

    T findById(String Id);

    void save(T t);
    void update(T t);
}
