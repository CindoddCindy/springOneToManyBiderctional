package com.otmbidirectional.otmBiderectional.controller;

import com.otmbidirectional.otmBiderectional.model.Archieve;
import com.otmbidirectional.otmBiderectional.model.Library;
import com.otmbidirectional.otmBiderectional.repository.ArchieveRepository;
import com.otmbidirectional.otmBiderectional.repository.BookRepository;
import com.otmbidirectional.otmBiderectional.repository.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/archieve")
public class ArchieveController {

    private final ArchieveRepository archieveRepository;
    private final BookRepository bookRepository;

    @Autowired
    public ArchieveController(ArchieveRepository archieveRepository, BookRepository bookRepository) {
        this.archieveRepository = archieveRepository;
        this.bookRepository = bookRepository;
    }

    @PostMapping
    public ResponseEntity<Archieve> create(@Valid @RequestBody Archieve archieve) {
        Archieve savedArchieve = archieveRepository.save(archieve);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedArchieve.getId()).toUri();

        return ResponseEntity.created(location).body(savedArchieve);
    }
/*
    @PutMapping("/{id}")
    public ResponseEntity<Library> update(@PathVariable Integer id, @Valid @RequestBody Library library) {
        Optional<Library> optionalLibrary = libraryRepository.findById(id);
        if (!optionalLibrary.isPresent()) {
            return ResponseEntity.unprocessableEntity().build();
        }

        library.setId(optionalLibrary.get().getId());
        libraryRepository.save(library);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Library> delete(@PathVariable Integer id) {
        Optional<Library> optionalLibrary = libraryRepository.findById(id);
        if (!optionalLibrary.isPresent()) {
            return ResponseEntity.unprocessableEntity().build();
        }

        libraryRepository.delete(optionalLibrary.get());

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Library> getById(@PathVariable Integer id) {
        Optional<Library> optionalLibrary = libraryRepository.findById(id);
        if (!optionalLibrary.isPresent()) {
            return ResponseEntity.unprocessableEntity().build();
        }

        return ResponseEntity.ok(optionalLibrary.get());
    }

    @GetMapping
    public ResponseEntity<Page<Library>> getAll(Pageable pageable) {
        return ResponseEntity.ok(libraryRepository.findAll(pageable));
    }

 */

}
