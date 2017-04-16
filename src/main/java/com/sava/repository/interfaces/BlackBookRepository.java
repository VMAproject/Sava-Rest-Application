package com.sava.repository.interfaces;

import com.sava.model.BlackBook;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by verlamov on 16.04.17.
 */
public interface BlackBookRepository extends JpaRepository<BlackBook, Long> {

    BlackBook findByName(String name);
}
