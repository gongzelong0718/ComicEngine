package com.xiaoyuz.comicengine.model.entity.base;

import android.os.Parcel;
import android.os.Parcelable;

import com.xiaoyuz.comicengine.model.entity.history.History;

import org.jsoup.nodes.Element;

import java.util.Date;

/**
 * Created by zhangxiaoyu on 16-11-9.
 */
public abstract class BaseSearchResult extends BaseEntity implements Parcelable {

    protected String bookCover;
    protected String status;
    protected String url;
    protected String title;
    protected String updateTime;
    protected String lastChapter;

    public BaseSearchResult() {
    }

    public BaseSearchResult(Element element) {
    }

    @Override
    public boolean equals(Object obj) {
        return url.equals(((BaseSearchResult) obj).url)
                && title.equals(((BaseSearchResult) obj).title);
    }

    @Override
    public String toString() {
        return new StringBuffer().append("Cover: ").append(bookCover).append("\n")
                .append("status: ").append(status).append("\n")
                .append("url: ").append(url).append("\n")
                .append("title: ").append(title).append("\n")
                .append("updatetime: ").append(updateTime).append("\n")
                .append("lastChaper: ").append(lastChapter).toString();
    }

    public String getBookCover() {
        return bookCover;
    }

    public String getStatus() {
        return status;
    }

    public String getUrl() {
        return url;
    }

    public String getTitle() {
        return title;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public String getLastChapter() {
        return lastChapter;
    }

    public void setBookCover(String bookCover) {
        this.bookCover = bookCover;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public void setLastChapter(String lastChapter) {
        this.lastChapter = lastChapter;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(bookCover);
        dest.writeString(status);
        dest.writeString(url);
        dest.writeString(title);
        dest.writeString(updateTime);
        dest.writeString(lastChapter);
    }

    public void fromHistory(History history) {
        setUrl(history.getUrl());
        setLastChapter(history.getLastChapter());
        setStatus(history.getStatus());
        setUpdateTime(history.getUpdateTime());
        setTitle(history.getTitle());
        setBookCover(history.getBookCover());
    }

    public History toHistory() {
        History history = new History();
        history.setBookCover(getBookCover());
        history.setTitle(getTitle());
        history.setUpdateTime(getUpdateTime());
        history.setStatus(getStatus());
        history.setLastChapter(getLastChapter());
        history.setUrl(getUrl());
        history.setHistoryTime(new Date());
        return history;
    }
}
