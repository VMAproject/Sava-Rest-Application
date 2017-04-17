package com.sava.service;

import com.sava.model.BlackBook;
import com.sava.repository.interfaces.BlackBookRepository;
import com.sava.service.interfaces.BlackBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by verlamov on 16.04.17.
 */
@Service("blackBookService")
@Transactional
public class BlackBookServiceImpl implements BlackBookService {

    @Autowired
    private BlackBookRepository blackBookRepository;


    @Override
    public BlackBook findById(Long id) {
        return blackBookRepository.findOne(id);
    }

    @Override
    public BlackBook fingByName(String name) {
        return blackBookRepository.findByName(name);
    }

    @Override
    public void saveBlackBook(BlackBook blackBook) {
        blackBookRepository.save(blackBook);

    }

    @Override
    public void updateBlackBook(BlackBook blackBook) {
        saveBlackBook(blackBook);

    }

    @Override
    public void deleteBlackBookById(Long id) {
        blackBookRepository.delete(id);

    }

    @Override
    public void deleteAllBlackBooks() {
        blackBookRepository.deleteAll();
    }


    @Override
    public List<BlackBook> findAllBlackBooks() {
        return blackBookRepository.findAll();
    }

    @Override
    public boolean isBlackBookExist(BlackBook blackBook) {
        return fingByName(blackBook.getName()) != null;
    }
}
