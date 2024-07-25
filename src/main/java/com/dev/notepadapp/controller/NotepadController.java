package com.dev.notepadapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.dev.notepadapp.entity.Notepad;
import com.dev.notepadapp.exception.NotepadNotFoundException;
import com.dev.notepadapp.response.ResponseStructure;
import com.dev.notepadapp.service.NotepadService;

@RestController
@CrossOrigin
public class NotepadController {

	@Autowired
	private NotepadService service;

	@GetMapping("/")
	public String welocme() {
		return "make Use Of Postman to save and find notes ";
	}

	@PostMapping("/notes/save")
	public ResponseEntity< ResponseStructure<Notepad>> saveNotepad(@RequestBody Notepad notepad) {
		
		return service.save(notepad);
	}

	@PostMapping("/notes/findAll")
	public ResponseEntity<ResponseStructure<List<Notepad>>> findAlNotes() {
		return service.findAll();
	}
	
	@GetMapping("/notes/findAll")
	public ResponseEntity<ResponseStructure<List<Notepad>>> findAlNots() {
		return service.findAll();
	}

	@GetMapping("notes/findById")
	public ResponseEntity<ResponseStructure<Notepad>> findById(@RequestParam int id) {
		return service.findById(id);
	}
	
	@DeleteMapping("/notes/delete")
	public ResponseEntity<ResponseStructure<Notepad>> deleteById(@RequestParam int id) {
		ResponseEntity<ResponseStructure<Notepad>> rs=service.deleteById(id);
		if(rs!=null) {
			return rs;
		}
		
		throw new NotepadNotFoundException("Notepad with given id "+id+" not found ");
	}
	
	@PutMapping("/notes/update")
	public String modifyNotes(@RequestBody Notepad notepad) {
		if(notepad!=null && notepad.getNotepadId()!=0&&service.existById(notepad.getNotepadId())) {
			service.save(notepad);
			return "Modify";
		}
		return "invalid Info";
	}

}
