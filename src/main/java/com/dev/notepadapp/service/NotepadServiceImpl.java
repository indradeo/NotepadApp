package com.dev.notepadapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.dev.notepadapp.entity.Notepad;
import com.dev.notepadapp.exception.NotepadNotFoundException;
import com.dev.notepadapp.repository.NotepadRepo;
import com.dev.notepadapp.response.ResponseStructure;

@Service
public class NotepadServiceImpl implements NotepadService {
	
	@Autowired
	NotepadRepo repo;
	
	@Override
	public ResponseEntity<ResponseStructure<List<Notepad>>> findAll() {
		ResponseStructure<List<Notepad>> responseStructure= new ResponseStructure<>();
		responseStructure.setMessage("Ok");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setData(repo.findAll());
		return new ResponseEntity<ResponseStructure<List<Notepad>>>(responseStructure,HttpStatus.OK);
	}

	@Override
	public ResponseEntity<ResponseStructure<Notepad>> save(Notepad notepad) {
		ResponseStructure<Notepad> structure=new ResponseStructure<>();
		structure.setStatusCode(HttpStatus.CREATED.value());
		structure.setMessage("Created");
		structure.setData(repo.save(notepad));
		return new ResponseEntity<ResponseStructure<Notepad>>(structure,HttpStatus.CREATED); 
		
	}

	@Override
	public ResponseEntity<ResponseStructure<Notepad>> findById(int id) {
		Optional<Notepad> optional=repo.findById(id);
		if(optional.isPresent()) {
			ResponseStructure< Notepad> responseStructure= new ResponseStructure<>();
			responseStructure.setData(optional.get());
			responseStructure.setMessage(HttpStatus.OK.getReasonPhrase());
			responseStructure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Notepad>>(responseStructure,HttpStatus.OK);
		}
		
		throw new NotepadNotFoundException("Notepad with given id "+id+" not found !! ");
	}

	@Override
	public ResponseEntity<ResponseStructure<Notepad>> deleteById(int id) {
		
		if(repo.existsById(id)) {
			ResponseStructure<Notepad> responseStructure=new ResponseStructure<>();
			responseStructure.setMessage("No content");
			responseStructure.setStatusCode(HttpStatus.NO_CONTENT.value());
			responseStructure.setData(repo.findById(id).get());
			repo.deleteById(id);
			return new ResponseEntity<ResponseStructure<Notepad>>(responseStructure,HttpStatus.NO_CONTENT);
		}
		throw new NotepadNotFoundException("Notepad not found with id "+id);
	}

	@Override
	public boolean existById(int id) {
		
		return repo.existsById(id);
	}

}
