package com.file.teste.essia.repository;

import com.file.teste.essia.model.Folder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FolderRepository extends JpaRepository<Folder, Long> {

    @Query("select f FROM Folder f where f.name = :name ")
    Folder getFolderByName(@Param("name") String name);
}
