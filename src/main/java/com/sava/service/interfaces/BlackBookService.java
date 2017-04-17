package com.sava.service.interfaces;

import com.sava.model.BlackBook;

import java.util.List;

/**
 * Created by verlamov on 16.04.17.
 */
public interface BlackBookService {

    BlackBook findById(Long id);

    BlackBook fingByName(String name);

    void saveBlackBook(BlackBook blackBook);

    void updateBlackBook(BlackBook blackBook);

    void deleteBlackBookById(Long id);

    void deleteAllBlackBooks();

    List<BlackBook> findAllBlackBooks();

    boolean isBlackBookExist(BlackBook blackBook);

}
