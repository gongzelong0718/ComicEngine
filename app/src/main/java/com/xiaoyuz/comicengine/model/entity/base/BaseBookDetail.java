package com.xiaoyuz.comicengine.model.entity.base;

import com.xiaoyuz.comicengine.model.entity.ChapterListTypeConverter;

import org.greenrobot.greendao.annotation.Convert;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.ToOne;
import org.jsoup.nodes.Element;

import java.io.Serializable;
import java.util.List;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.DaoException;

/**
 * Created by zhangxiaoyu on 16-11-9.
 */
@Entity
public class BaseBookDetail extends BaseEntity implements Serializable {

    public static final long serialVersionUID = 536871008;
    // Used for db ID.
    @Id
    protected String url;
    @ToOne(joinProperty = "url")
    protected BaseSearchResult searchResult;
    protected String description;
    @Convert(converter = ChapterListTypeConverter.class, columnType = String.class)
    protected List<BaseChapter> chapters;
    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;
    /** Used for active entity operations. */
    @Generated(hash = 1146534919)
    private transient BaseBookDetailDao myDao;
    @Generated(hash = 2141809651)
    private transient String searchResult__resolvedKey;

    public BaseBookDetail(){
    }

    public BaseBookDetail(Element element) {

    }

    @Generated(hash = 1268527853)
    public BaseBookDetail(String url, String description,
            List<BaseChapter> chapters) {
        this.url = url;
        this.description = description;
        this.chapters = chapters;
    }

    public BaseSearchResult getSearchResultEntity() {
        return searchResult;
    }

    public void injectSearchResult(BaseSearchResult searchResult) {
        this.url = searchResult.getUrl();
        this.searchResult = searchResult;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<BaseChapter> getChapters() {
        return chapters;
    }

    public void setChapters(List<BaseChapter> chapters) {
        this.chapters = chapters;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    /** To-one relationship, resolved on first access. */
    @Generated(hash = 1226556979)
    public BaseSearchResult getSearchResult() {
        String __key = this.url;
        if (searchResult__resolvedKey == null
                || searchResult__resolvedKey != __key) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            BaseSearchResultDao targetDao = daoSession.getBaseSearchResultDao();
            BaseSearchResult searchResultNew = targetDao.load(__key);
            synchronized (this) {
                searchResult = searchResultNew;
                searchResult__resolvedKey = __key;
            }
        }
        return searchResult;
    }

    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 1516691053)
    public void setSearchResult(BaseSearchResult searchResult) {
        synchronized (this) {
            this.searchResult = searchResult;
            url = searchResult == null ? null : searchResult.getUrl();
            searchResult__resolvedKey = url;
        }
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#delete(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 128553479)
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.delete(this);
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#refresh(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 1942392019)
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.refresh(this);
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#update(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 713229351)
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.update(this);
    }

    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 1328026249)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getBaseBookDetailDao() : null;
    }
}
