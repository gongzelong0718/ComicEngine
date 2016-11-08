package com.xiaoyuz.comicengine.db.source.repository;

import com.xiaoyuz.comicengine.db.source.BookDataSource;
import com.xiaoyuz.comicengine.entity.BookDetail;
import com.xiaoyuz.comicengine.entity.Page;
import com.xiaoyuz.comicengine.entity.SearchResult;

import java.util.List;

import rx.Observable;

/**
 * Search result should not be cached, so here only use remote data source.
 * Created by zhangxiaoyu on 16-10-28.
 */
public class BookRepository implements BookDataSource {

    private static BookRepository sInstance;

    private BookDataSource mBookLocalDataSource;
    private BookDataSource mBookRemoteDataSource;

    private BookRepository(BookDataSource bookLocalDataSource,
                           BookDataSource bookRemoteDataSource) {
        mBookLocalDataSource = bookLocalDataSource;
        mBookRemoteDataSource = bookRemoteDataSource;
    }

    public static BookRepository getInstance(
            BookDataSource bookLocalDataSource, BookDataSource bookRemoteDataSource) {
        if (sInstance == null) {
            sInstance = new BookRepository(bookLocalDataSource, bookRemoteDataSource);
        }
        return sInstance;
    }

    @Override
    public Observable<List<SearchResult>> getSearchResults(String keyword, int page) {
        return mBookRemoteDataSource.getSearchResults(keyword, page);
    }

    @Override
    public Observable<BookDetail> getBookDetail(String url) {
        return mBookRemoteDataSource.getBookDetail(url);
    }

    @Override
    public Observable<String> getHtml(String url) {
        // If no local html, no need to load remotely,
        // just return empty string so presenter will handle it.
        // Because webview need to load url remotely so we must do like this.
        return mBookLocalDataSource.getHtml(url);
    }

    @Override
    public Observable<Page> getPage(String html) {
        return mBookRemoteDataSource.getPage(html);
    }

    @Override
    public Observable<String> getChapterHistory(String bookUrl) {
        return mBookLocalDataSource.getChapterHistory(bookUrl);
    }

    @Override
    public Observable<Object> saveHtml(String url, String html) {
        return mBookLocalDataSource.saveHtml(url, html);
    }

    @Override
    public Observable<Object> saveChapterHistory(String bookUrl, int chapterIndex,
                                                 String chapterTitle, int position) {
        return mBookLocalDataSource.saveChapterHistory(bookUrl, chapterIndex,
                chapterTitle, position);
    }
}
