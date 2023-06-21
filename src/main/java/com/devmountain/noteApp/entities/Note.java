package com.devmountain.noteApp.entities;

import com.devmountain.noteApp.dtos.NoteDto;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "notes")
@Data //rid of constructors and getter/setter
@AllArgsConstructor
@NoArgsConstructor
public class Note {

    public Note(NoteDto noteDto){
        if(noteDto.getBody() != null){
            this.body = noteDto.getBody();
        }
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "text")
    private String body;

    @ManyToOne
    @JsonBackReference
    private User user;
}
