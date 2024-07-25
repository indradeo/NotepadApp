package com.dev.notepadapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.dev.notepadapp.entity.Notepad;

public interface NotepadRepo extends JpaRepository<Notepad, Integer> {

}
