package com.dev.notepadapp.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.dev.notepadapp.entity.Notepad;
import com.dev.notepadapp.response.ResponseStructure;

@Service
public interface NotepadService {
	
	public ResponseEntity<ResponseStructure<Notepad>> save(Notepad notepad);
	public ResponseEntity<ResponseStructure<List<Notepad>>> findAll();
	public ResponseEntity<ResponseStructure<Notepad>> findById(int id);
	public ResponseEntity<ResponseStructure<Notepad>> deleteById(int id);
	public boolean existById(int id);
	
}
