package com.edou.fileserver.service;

import com.edou.fileserver.domain.File;
import com.edou.fileserver.repository.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @ClassName FileServiceImpl
 * @Description 文件服务service层
 * @Author 中森明菜
 * @Date 2020/3/21 18:35
 * @Version 1.0
 */
@Service
public class FileServiceImpl implements FileService {
    @Autowired
    public FileRepository fileRepository;

    //保存文件
    @Override
    public File saveFile(File file) {
        return fileRepository.save(file);
    }

    //删除文件
    @Override
    public void removeFile(String id) {
        fileRepository.deleteById(id);
    }

    //获取文件
    @Override
    public Optional<File> getFileById(String id) {
        return fileRepository.findById(id);
    }

    //分页查询文件列表 降序
    @Override
    public List<File> listFilesByPage(int pageIndex, int pageSize) {
        Page<File> page = null;
        List<File> list = null;

        Sort sort = new Sort(Sort.Direction.DESC,"uploadDate");
        Pageable pageable = PageRequest.of(pageIndex, pageSize, sort);

        page = fileRepository.findAll(pageable);
        list = page.getContent();
        return list;
    }
}
