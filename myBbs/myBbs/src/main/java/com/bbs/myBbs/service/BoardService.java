package com.bbs.myBbs.service;

import com.bbs.myBbs.model.Board;
import com.bbs.myBbs.model.User;
import com.bbs.myBbs.repository.BoardRepository;
import com.bbs.myBbs.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardService {

    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    private UserRepository userRepository;

    public Board save(String username, Board board) {
        User user = userRepository.findByUsername(username);
        board.setUser(user);
        return boardRepository.save(board);
    }

}
