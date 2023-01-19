package com.example.ddooheeJpa.paging;

import org.springframework.data.domain.AbstractPageRequest;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.util.Assert;

public class PageRequest extends AbstractPageRequest {

    private static final long serialVersionUID = -4541409938956089562L;

    private final Sort sort;

    /**
     * Creates a new PageRequest with sort parameters applied.
     * 매개변수: page - zero-based page index, must not be negative.
     *         size - the size of the page to be returned, must be greater than 0.
     *         sort - must not be null, use Sort.unsorted() instead.
     */

    protected PageRequest(int page, int size, Sort sort) {

        super(page, size);

        Assert.notNull(sort, "Sort must not be null");

        this.sort = sort;
    }

    /**
     * Creates a new unsorted PageRequest.
     * 매개변수 page - page - zero-based page index, must not be negative.
     *        size - the size of the page to be returned, must be greater than 0.
     * 시작 시간 2.0
     */
    public static PageRequest of(int page, int size) {
        return of(page, size, Sort.unsorted());
    }

    /**
     * Creates a new PageRequest with sort parameters applied.
     * 매개변수 page - page - zero-based page index, must not be negative.
     *        size - the size of the page to be returned, must be greater than 0.
     *        sort - must not be null, use Sort.unsorted() instead.
     * 시작 시간 2.0
     */
    public static PageRequest of(int page, int size, Sort sort) {
        return new PageRequest(page, size, sort);
    }

    /**
     * Creates a new PageRequest with sort direction and properties applied.
     * 매개변수 page - page - zero-based page index, must not be negative.
     *        size - the size of the page to be returned, must be greater than 0.
     *        direction - must not be null.
     *        properties - must not be null.
     * 시작 시간 2.0
     */
    public static PageRequest of(int page, int size, Sort.Direction direction, String... properties) {
        return of(page, size, Sort.by(direction, properties));
    }


    @Override
    public Sort getSort() {
        return null;
    }

    @Override
    public Pageable next() {
        return null;
    }

    @Override
    public Pageable previous() {
        return null;
    }

    @Override
    public Pageable first() {
        return null;
    }

    @Override
    public Pageable withPage(int pageNumber) {
        return null;
    }
}
