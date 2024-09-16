package org.example.backend.common.excel.importer;

/**
 * @Description:
 * @Author: liwu3
 * @Date: 2022/10/28 14:47
 */
public interface SaveDataHandler<E> {

    void insert(E data);

}
