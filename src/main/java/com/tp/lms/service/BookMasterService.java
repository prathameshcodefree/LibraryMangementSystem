package com.tp.lms.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tp.lms.model.BookMaster;
import com.tp.lms.repository.BookMasterRepository;

@Service
public class BookMasterService {

	@Autowired
	BookMasterRepository bookMasterRepository;

	public List<String> validate(BookMaster bookMaster) {
		List<String> error = new ArrayList<>();

		if (bookMaster.getBookCategory() == null) {
			error.add("Book Category can not be empty");
		}

		if (bookMaster.getBookSubCategory() == null) {
			error.add("Book Sub Category can not be empty");
		}
		if (bookMaster.getTitle() == null) {
			error.add("Title can not be empty");
		}
		if (bookMaster.getAuthor() == null) {
			error.add("Author can not be empty");
		}
		if (Float.compare(bookMaster.getPrice(), 0.0f) == 0) {
			error.add("FineAmount cannot be empty");
		}
		if (bookMaster.getPublishBy() == null) {
			error.add("Publish By can not be empty");
		}

		return error;
	}

	public List<BookMaster> getBookMaster() {
		return bookMasterRepository.findAll();
	}

	public Optional<BookMaster> getBookMasterById(Integer bookMasterId) {
		return bookMasterRepository.findById(bookMasterId);
	}

	public BookMaster addBookMaster(BookMaster bookMaster) {
		return bookMasterRepository.save(bookMaster);
	}

	public BookMaster updateBookMaster(Integer id, BookMaster bookMaster) {
		BookMaster existingBookMaster = bookMasterRepository.findById(id).orElse(null);

		existingBookMaster.setTitle(bookMaster.getTitle());
		existingBookMaster.setAuthor(bookMaster.getAuthor());
		existingBookMaster.setPrice(bookMaster.getPrice());
		existingBookMaster.setPublishBy(bookMaster.getPublishBy());

		return bookMasterRepository.save(existingBookMaster);
	}

	public boolean deleteBookMaster(Integer id) {
		boolean exists = bookMasterRepository.existsById(id);
		if (exists) {
			bookMasterRepository.deleteById(id);
			return true;
		} else {
			return false;
		}
	}

}
