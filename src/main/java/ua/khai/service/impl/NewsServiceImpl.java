package ua.khai.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ua.khai.crud.CrudRepositoryHelper;
import ua.khai.datatable.DataTableRequest;
import ua.khai.datatable.DataTableResponse;
import ua.khai.entity.News;
import ua.khai.repository.NewsRepository;
import ua.khai.service.NewsService;

import java.util.Optional;

@Service
public class NewsServiceImpl implements NewsService {

    private final NewsRepository newsRepository;
    private final CrudRepositoryHelper<News, NewsRepository> crudRepositoryHelper;

    public NewsServiceImpl(NewsRepository newsRepository, CrudRepositoryHelper<News, NewsRepository> crudRepositoryHelper) {
        this.newsRepository = newsRepository;
        this.crudRepositoryHelper = crudRepositoryHelper;
    }

    @Override
    @Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    public void create(News entity) {
        crudRepositoryHelper.create(newsRepository, entity);
    }

    @Override
    public void update(News entity) {
        crudRepositoryHelper.update(newsRepository, entity);
    }

    @Override
    public void delete(Long id) {
        crudRepositoryHelper.delete(newsRepository, id);
    }

    @Override
    public Optional<News> findById(Long id) {
        return crudRepositoryHelper.findById(newsRepository, id);
    }

    @Override
    public DataTableResponse<News> findAll(DataTableRequest request) {
        return crudRepositoryHelper.findAll(newsRepository,request);
    }
}
