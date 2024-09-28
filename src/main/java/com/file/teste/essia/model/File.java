package com.file.teste.essia.model;


import jakarta.persistence.*;


@Entity
@Table(name = "file")
public class File extends BaseEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "parent_folder_id", nullable = false)
    private Folder sourceFolder;

    @Column(name = "file_content", nullable = true)
    private String fileContent;

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

    public Folder getSourceFolder() {
        return sourceFolder;
    }

    public void setSourceFolder(Folder sourceFolder) {
        this.sourceFolder = sourceFolder;
    }
}
