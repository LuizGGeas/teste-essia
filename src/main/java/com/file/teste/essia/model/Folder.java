package com.file.teste.essia.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "folder")
@JsonIgnoreProperties(value = { "parentFolder" }, allowSetters = true)
public class Folder extends BaseEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "parent_folder_id")
    private Folder parentFolder;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "parentFolder", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<Folder> subFolderList;

    @OneToMany(mappedBy = "sourceFolder", orphanRemoval = true, fetch = FetchType.EAGER)
    private List<File> fileList;

    public Folder() {
        fileList = new ArrayList<>();
        subFolderList = new ArrayList<>();
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Folder> getSubFolderList() {
        return subFolderList;
    }

    public void stSubFolders(List<Folder> subFolders) {
        this.subFolderList = subFolders;
    }

    public List<File> getFileList() {
        return fileList;
    }

    public void setFileList(List<File> fileList) {
        this.fileList = fileList;
    }

    public Folder getParentFolder() {
        return parentFolder;
    }

    public void setParentFolder(Folder parentFolder) {
        this.parentFolder = parentFolder;
    }
}
