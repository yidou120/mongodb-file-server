package com.edou.fileserver.repository;

import com.edou.fileserver.domain.File;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FileRepository extends MongoRepository<File,String> {
}
